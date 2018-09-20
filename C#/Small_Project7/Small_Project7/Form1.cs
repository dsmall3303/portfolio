//Payroll GUI applicaiton
//Coded by David Small with assistance from Barret Gaylor on 16 August 2014

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Small_Project7
{
    public partial class MainPane : Form
    {
        const int MAX_EMPLOYEES = 50;   //Avoiding "magic numbers"

        Employee[] payroll = new Employee[MAX_EMPLOYEES];   //array to hold employees in the backend

        int employeeIndex = 0;  //index for indexing


        public MainPane()
        {
            InitializeComponent();
        }

        private void BAddToPayroll_Click(object sender, EventArgs e)    //Fires upon clicking the "Add" button
        {
                try
                {
                    float test = 0.0f;
                    Employee temp = new Employee();             //making employee to add to payroll
                    temp.FirstName = TBEmployeeNameFirst.Text;
                    temp.LastName = TBEmployeeNameLast.Text;
                    temp.PhoneNumber = TBPhoneNumber.Text;
                    temp.Address.StreetAddress = TBAddress.Text;
                    temp.Address.ApartmentNumber = TBApartmentNumber.Text;
                    temp.Address.City = TBCity.Text;
                    temp.Address.State = TBState.Text;
                    temp.Address.ZipCode = TBZipCode.Text;
                    temp.Title = TBJobTitle.Text;
                    if (float.TryParse(TBWage.Text, out test))  //sanity check for wage
                    {
                        temp.Wage = float.Parse(TBWage.Text);
                    }
                    temp.IsOnPayroll = CBIsOnPayroll.Checked;
                    if (float.TryParse(TBHoursWorked.Text, out test))   //sanity check for hours worked
                    {
                        temp.HoursWorked = float.Parse(TBHoursWorked.Text);
                    }
                    payroll[employeeIndex] = temp;      //adds employee to payroll

                    PayrollList.Items.Add(payroll[employeeIndex]);  //adds employee to visible payroll
                    employeeIndex++;    //increment index
                }
                catch (PhoneNumberException)    //Exception handling!
                {
                    MessageBox.Show("Phone numbers must be ten digits!");
                }
                catch (WageException)
                {
                    MessageBox.Show("Can't have negative wages!");
                }
                catch (TimeWorkedException)
                {
                    MessageBox.Show("Can't have negative hours worked!");
                }
                catch (Exception)
                {
                    MessageBox.Show("Something is wrong.\nThat's all we know.");
                }
                TBEmployeeNameFirst.Clear();    //returning fields to their default state
                TBEmployeeNameLast.Clear();
                TBPhoneNumber.Clear();
                TBAddress.Clear();
                TBApartmentNumber.Clear();
                TBCity.Clear();
                TBState.Clear();
                TBZipCode.Clear();
                TBJobTitle.Clear();
                TBWage.Clear();
                CBIsOnPayroll.Checked = false;
                TBHoursWorked.Clear();
        }

        private void BModifyEmployee_Click(object sender, EventArgs e)  //fires on clicking the "Edit" button
        {
            BModifyDone.Visible = true;         //shows the "Done" button

            BAddToPayroll.Visible = false;      //hides the "Add" button

            BModifyEmployee.Visible = false;    //Hides the "Edit" button

            BPayEmployee.Visible = false;       //Hides the "Pay" button

            Employee emp = (Employee)PayrollList.SelectedItem;  //copies the selected employee from the visible payroll to the backend

            TBEmployeeNameFirst.Text = emp.FirstName;   //loads the fields with the correct informaiton
            TBEmployeeNameLast.Text = emp.LastName;
            TBPhoneNumber.Text = emp.PhoneNumber;
            TBAddress.Text = emp.Address.StreetAddress;
            TBApartmentNumber.Text = emp.Address.ApartmentNumber;
            TBCity.Text = emp.Address.City;
            TBState.Text = emp.Address.State;
            TBZipCode.Text = emp.Address.ZipCode;
            TBJobTitle.Text = emp.Title;
            TBWage.Text = emp.Wage.ToString();
            CBIsOnPayroll.Checked = emp.IsOnPayroll;
            TBHoursWorked.Text = emp.HoursWorked.ToString();
        }

        private void BModifyDone_Click(object sender, EventArgs e)  //fires on clicking the "Done" button
        {

            int index = PayrollList.Items.IndexOf(PayrollList.SelectedItem);    //gets the index of the selected employee in the visible payroll

            Employee emp = (Employee)PayrollList.SelectedItem;  //copies the selected employee from the visible payroll to the backend

            PayrollList.Items.Remove(PayrollList.SelectedItem);     //removes the selected visible employee

            try
            {                                                   //alters the employee's data in the backend payroll using same methods as creating
                float test = 0.0f;
                emp.FirstName = TBEmployeeNameFirst.Text;
                emp.LastName = TBEmployeeNameLast.Text;
                emp.PhoneNumber = TBPhoneNumber.Text;
                emp.Address.StreetAddress = TBAddress.Text;
                emp.Address.ApartmentNumber = TBApartmentNumber.Text;
                emp.Address.City = TBCity.Text;
                emp.Address.State = TBState.Text;
                emp.Address.ZipCode = TBZipCode.Text;
                emp.Title = TBJobTitle.Text;
                if (float.TryParse(TBWage.Text, out test))
                {
                    emp.Wage = float.Parse(TBWage.Text);
                }
                emp.IsOnPayroll = CBIsOnPayroll.Checked;
                if (float.TryParse(TBHoursWorked.Text, out test))
                {
                    emp.HoursWorked = float.Parse(TBHoursWorked.Text);
                }

                BModifyDone.Visible = false;    //hides the "Done" button

                BAddToPayroll.Visible = true;   //shows the "Add" button

                BModifyEmployee.Visible = true; //shows the "Edit" button

                BPayEmployee.Visible = true;    //shows the "Pay" button
            }
            catch (PhoneNumberException)    //Exception handling!
            {
                MessageBox.Show("Phone numbers must be ten digits!");
            }
            catch (WageException)
            {
                MessageBox.Show("Can't have negative wages!");
            }
            catch (TimeWorkedException)
            {
                MessageBox.Show("Can't have negative hours worked!");
            }
            catch (Exception)
            {
                MessageBox.Show("Something is wrong.\nThat's all we know.");
            }

            PayrollList.Items.Insert(index, emp);   //"refreshes" the visible employee with the correct info

            TBEmployeeNameFirst.Clear();    //returns fields to the default state
            TBEmployeeNameLast.Clear();
            TBPhoneNumber.Clear();
            TBAddress.Clear();
            TBApartmentNumber.Clear();
            TBCity.Clear();
            TBState.Clear();
            TBZipCode.Clear();
            TBJobTitle.Clear();
            TBWage.Clear();
            CBIsOnPayroll.Checked = false;
            TBHoursWorked.Clear();

        }

        private void BPayEmployee_Click(object sender, EventArgs e)     //fires on clicking the "Pay" button
        {
            Employee emp = (Employee)PayrollList.SelectedItem;  //Copies the visible employee to the backend

            if (emp.IsOnPayroll)    //checks if on the payroll
            {
                float pay = emp.Wage * emp.HoursWorked;

                string payString = string.Format("{0} {1} has earned ${2}.", emp.FirstName, emp.LastName, pay);

                MessageBox.Show(payString);     //shows how much they've earned
            }
            else
            {
                MessageBox.Show("This employee is not on the payroll!");
            }
        }

        private void enptyPayrollToolStripMenuItem_Click(object sender, EventArgs e)    //fires on clicking the "Empty payroll" menu item
        {
            for (int i = 0; i < MAX_EMPLOYEES; i++)
                payroll[i] = new Employee();    //resets all employees to default values
            PayrollList.Items.Clear();      //clears visible payroll
        }

        private void displayFullInfoToolStripMenuItem_Click(object sender, EventArgs e) //fires on clicking the "Display Full Info" menu item
        {
            Employee emp = (Employee)PayrollList.SelectedItem;

            string displayString = emp.DisplayEmployee();

            MessageBox.Show(displayString); //shows all of the employee's information
        }




    }
}
