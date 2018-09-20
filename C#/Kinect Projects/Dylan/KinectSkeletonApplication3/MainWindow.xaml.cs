using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using Microsoft.Kinect;
using Microsoft.Runtime;



namespace KinectSkeletonApplication3
{
    public partial class MainWindow : Window
    {
        //Instantiate the Kinect runtime. Required to initialize the device.
        //IMPORTANT NOTE: You can pass the device ID here, in case more than one Kinect device is connected.

        
   //     Runtime runtime = Runtime.Kinects[0];
        KinectSensor runtime = KinectSensor.KinectSensors[0];


        public MainWindow()
        {
            InitializeComponent();

            //Runtime initialization is handled when the window is opened. When the window
            //is closed, the runtime MUST be unitialized.
            this.Loaded += new RoutedEventHandler(MainWindow_Loaded);
            this.Unloaded += new RoutedEventHandler(MainWindow_Unloaded);

            runtime.SkeletonFrameReady += new EventHandler<SkeletonFrameReadyEventArgs>(runtime_SkeletonFrameReady);
        }

        void runtime_SkeletonFrameReady(object sender, SkeletonFrameReadyEventArgs e)
        {
            Skeleton[] mySkeletons = null;
            Skeleton data = null;
            bool haveSkeletons = false;
            using (SkeletonFrame skeletonFrame = e.OpenSkeletonFrame())
            {
                if (null != skeletonFrame)
                {
                    if ((null == mySkeletons) || (mySkeletons.Length != skeletonFrame.SkeletonArrayLength))
                    {
                        mySkeletons = new Skeleton[skeletonFrame.SkeletonArrayLength];
                    }
                    skeletonFrame.CopySkeletonDataTo(mySkeletons);
                    haveSkeletons = true;
                }
            }
            if (haveSkeletons)
            {
                data = (from s in mySkeletons
                             where s.TrackingState == SkeletonTrackingState.Tracked
                             select s).FirstOrDefault();
            }
            if (data != null)
            {
                SetEllipsePosition(Head, data.Joints[JointType.Head]);
                SetEllipsePosition(leftHand, data.Joints[JointType.HandLeft]);
                SetEllipsePosition(rightHand, data.Joints[JointType.HandRight]);
                ProcessGesture(data.Joints[JointType.Head], data.Joints[JointType.HandLeft], data.Joints[JointType.HandRight]);
            }     
              
        }

        private void ProcessGesture(Joint head, Joint handLeft, Joint handRight)
        {
            if ((handRight.Position.Y > head.Position.Y) || (handLeft.Position.Y > head.Position.Y))
            {
                MessageBox.Show("Your hand is above your head, bitch.");
            }
            else if ((handRight.Position.Y < 0) || (handLeft.Position.Y < 0))
            {
                MessageBox.Show("Your hand is below your waist, bitch.");
            }
            else if (handRight.Position.X < handLeft.Position.X)
            {
                MessageBox.Show("Your hands are crossed, bitch.");
            }
        }


        private void SetEllipsePosition(Ellipse ellipse, Joint joint)
        {
            Microsoft.Kinect.SkeletonPoint vector = new Microsoft.Kinect.SkeletonPoint();
            vector.X = ScaleVector(640, joint.Position.X);
            vector.Y = ScaleVector(480, -joint.Position.Y);
            vector.Z = joint.Position.Z;

            Joint updatedJoint = new Joint();
            updatedJoint.Position = joint.Position;
            updatedJoint.TrackingState = JointTrackingState.Tracked;
            updatedJoint.Position.X.Equals(vector.X);


            Canvas.SetLeft(ellipse, updatedJoint.Position.X);
            Canvas.SetTop(ellipse, updatedJoint.Position.Y);

           
        }

        private float ScaleVector(int length, float position)
        {
            float value = (((((float)length) / 1f) / 2f) * position) + (length / 2);
            if (value > length)
            {
                return (float)length;
            }
            if (value < 0f)
            {
                return 0f;
            }
            return value;
        }

        void MainWindow_Unloaded(object sender, RoutedEventArgs e)
        {
            runtime.Dispose();
            runtime.Stop();
        }

        void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            KinectSensor kinectSensor = KinectSensor.KinectSensors[0];
            //Since only a color video stream is needed, RuntimeOptions.UseColor is used.
            //runtime.Initialize(Microsoft.Kinect.RuntimeOptions.UseColor | RuntimeOptions.UseSkeletalTracking);

            runtime.Start();
            kinectSensor.Start();
            kinectSensor.ColorStream.Enable();
            kinectSensor.DepthStream.Enable();
        }
    }
}
