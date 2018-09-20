//employee class
//Coded by David Small on 20 July 2014
//Updated to have expection handling on 2 August 2014
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project_5
{
    [Serializable]
    public class WageException : Exception
    {
        public WageException() { }
        public WageException(string message) : base(message) { }
        public WageException(string message, Exception inner) : base(message, inner) { }
        protected WageException(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }

    [Serializable]
    public class TimeWorkedException : Exception
    {
        public TimeWorkedException() { }
        public TimeWorkedException(string message) : base(message) { }
        public TimeWorkedException(string message, Exception inner) : base(message, inner) { }
        protected TimeWorkedException(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }


    class Employee : Person     //Employee inherits from Person
    {
        private string title = "";

        public string Title
        {
            get { return title; }
            set { title = value; }
        }

        private float wage = 0.0f;

        public float Wage
        {
            get { return wage; }
            set
            {
                if (value >= 0.0f)
                    wage = value;
                else
                    throw new WageException();
            }
        }

        private float hoursWorked = 0.0f;

        public float HoursWorked
        {
            get { return hoursWorked; }
            set
            {
                if (value >= 0.0f)
                    hoursWorked = value;
                else
                    throw new TimeWorkedException();
            }
        }

        private bool isOnPayroll = true;

        public bool IsOnPayroll
        {
            get { return isOnPayroll; }
            set { isOnPayroll = value; }
        }

        public static float Pay(Employee emp)
        {
            float pay = (float)emp.Wage * emp.HoursWorked;
            return pay;
        }

        public Employee()
        {
            this.title = "Nonesuch";
            this.hoursWorked = 0.0f;
            this.wage = 0.0f;
            this.isOnPayroll = true;
        }

        public Employee(string initTitle, float initHours, float initWage, bool isPayrolled)
        {

            this.title = initTitle;
            this.hoursWorked = initHours;
            this.wage = initWage;
            this.isOnPayroll = isPayrolled;
        }

        public override string ToString()   //two different outcomes based on status of payroll
        {
            if (this.isOnPayroll)
            {
                return string.Format("\nName: {0} {1}\nPosition: {2}\nHours worked: {3}\nSalary: ${4}/hr\nPhone: {5}\nAddress: {6}",
                                        this.FirstName, this.LastName, this.title, this.hoursWorked, this.wage, this.PhoneNumber, this.Address);
            }
            else
                return string.Format("\nName: {0} {1}\nPhone: {2}\nAddress: {3}", this.FirstName, this.LastName, this.PhoneNumber, this.Address);
        }

    }
}
