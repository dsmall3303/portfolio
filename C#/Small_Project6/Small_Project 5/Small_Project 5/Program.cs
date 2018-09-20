//Employee class demo program
//Coded by David Small on 20 July 2014
//Updated to have expection handling on 2 August 2014

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project_5
{
    class Program
    {
        const int MAX_EMPLOYEES = 50;   //avoiding magic numbers

        static void Main(string[] args)
        {
            Employee[] payroll = new Employee[MAX_EMPLOYEES];
            for (int i = 0; i < MAX_EMPLOYEES; i++)     //initializing the array
                payroll[i] = new Employee();

            char menuChoice = '5';
            string userInput = "";

            int employeeIndex = 0;  //counter to keep track of number of employees

            try
            {
                do
                {
                    displayMenu();
                    menuChoice = char.Parse(Console.ReadLine());
                    switch (menuChoice)
                    {
                        case '1':
                            addEmployee(ref payroll, ref employeeIndex);
                            break;
                        case '2':
                            displayEmployees(ref payroll);
                            Console.WriteLine("Which employee would you like to update?");
                            Console.WriteLine("Please enter their number here:  ");
                            userInput = Console.ReadLine();
                            updateEmployee(userInput, ref payroll);
                            break;
                        case '3':
                            payEmployees(ref payroll);
                            break;
                        case '5':
                            break;
                        default:
                            Console.WriteLine("Something went wrong!");
                            break;
                    }

                } while (menuChoice != '5');
            }
            catch (WageException ex)
            {
                Console.WriteLine("Cannot have a negative wage!");
            }
            catch (TimeWorkedException ex)
            {
                Console.WriteLine("Can't have negative hours!");
            }
            catch (PhoneNumberException ex)
            {
                Console.WriteLine("Phone numbers must be 10 digits long!");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Something went wrong! Have an error message:\n{0}", ex.Message);
            }


        }

        //Function to display main menu
        private static void displayMenu()
        {
            Console.WriteLine("Please choose one of the following:");
            Console.WriteLine("1) Add employee to payroll");
            Console.WriteLine("2) Update an employee's information");
            Console.WriteLine("3) Pay employees");
            Console.WriteLine("5) Quit");
            Console.WriteLine("Please enter your choice here: ");
        }

        //function to list employees
        private static void displayEmployees(ref Employee[] payroll)
        {
            int employeeCount = 0;
            Console.WriteLine("Here's who's on the payroll right now:");
            foreach (Employee employee in payroll)
            {
                if (employee.Address.State != "Nonesuch")
                {
                    Console.WriteLine(employeeCount.ToString() + ")" + employee.ToString());
                    Console.WriteLine("");
                    employeeCount++;
                }
            }
        }

        //function to add employees to array
        private static void addEmployee(ref Employee[] payroll, ref int employeeIndex)
        {
            if (payroll[(MAX_EMPLOYEES - 1)].Address.State == "Nonesuch")   //check if the last spot in the array has been used already
            {
                string userInput = "";
                Console.WriteLine("Please enter the employee's first name:  ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].FirstName = userInput;

                Console.WriteLine("Please enter the employee's last name:  ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].LastName = userInput;

                Console.WriteLine("Please enter the employee's job title: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Title = userInput;

                Console.WriteLine("Please enter the employee's number of worked hours: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].HoursWorked = float.Parse(userInput);

                Console.WriteLine("Please enter the employee's salary in dollars per hour: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Wage = float.Parse(userInput);

                Console.WriteLine("Please enter the employee's phone number: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].PhoneNumber = userInput;

                Console.WriteLine("Please enter the employee's street address\nexcluding any apartment numbers: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Address.StreetAddress = userInput;

                Console.WriteLine("Does this employee's address have an apartment number (y/n)?  ");
                userInput = Console.ReadLine();

                if (userInput[0] == 'y' || userInput[0] == 'Y')
                {
                    Console.Write("Please enter it here:  ");
                    userInput = Console.ReadLine();
                    payroll[employeeIndex].Address.ApartmentNumber = userInput;
                }

                Console.WriteLine("Please enter the employee's city of residence: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Address.City = userInput;

                Console.WriteLine("Please enter the employee's state of residence: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Address.State = userInput;

                Console.WriteLine("Please enter the employee's zip code: ");
                userInput = Console.ReadLine();
                payroll[employeeIndex].Address.ZipCode = userInput;

                if (employeeIndex < payroll.Length)
                {
                    employeeIndex++;    //increment number of employees
                }
            }
            else
            {
                Console.WriteLine("Sorry, the payroll is full!");
            }

        }

        //function to update one attribute of one employee
        private static void updateEmployee(string employeeIndex, ref Employee[] payroll)
        {
            string userInput = "";
            int menuChoice = 0;
            Console.WriteLine("Which attribute would you like to update?");
            Console.WriteLine("1 ) First Name");
            Console.WriteLine("2 ) Last Name");
            Console.WriteLine("3 ) Title");
            Console.WriteLine("4 ) Hours Worked");
            Console.WriteLine("5 ) Salary");
            Console.WriteLine("6 ) Phone number");
            Console.WriteLine("7 ) Street address");
            Console.WriteLine("8 ) Apartment number");
            Console.WriteLine("9 ) City of residence");
            Console.WriteLine("10) State of residence");
            Console.WriteLine("11) Zip code");
            Console.WriteLine("99) Go back");
            Console.WriteLine("Please enter your choice here: ");
            menuChoice = int.Parse(Console.ReadLine());

            switch (menuChoice)
            {
                case 1:
                    Console.WriteLine("Please enter the employee's first name:  ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].FirstName = userInput;
                    break;
                case 2:
                    Console.WriteLine("Please enter the employee's last name:  ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].LastName = userInput;
                    break;
                case 3:
                    Console.WriteLine("Please enter the employee's job title: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Title = userInput;
                    break;
                case 4:
                    Console.WriteLine("Please enter the employee's number of worked hours: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].HoursWorked = float.Parse(userInput);
                    break;
                case 5:
                    Console.WriteLine("Please enter the employee's salary in dollars per hour: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Wage = float.Parse(userInput);
                    break;
                case 6:
                    Console.WriteLine("Please enter the employee's phone number: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].PhoneNumber = userInput;
                    break;
                case 7:
                    Console.WriteLine("Please enter the employee's street address\nexcluding any apartment numbers: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Address.StreetAddress = userInput;
                    break;
                case 8:
                    Console.Write("Please enter the employee's apartment number:  ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Address.ApartmentNumber = userInput;
                    break;
                case 9:
                    Console.WriteLine("Please enter the employee's city of residence: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Address.City = userInput;
                    break;
                case 10:
                    Console.WriteLine("Please enter the employee's state of residence: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Address.State = userInput;
                    break;
                case 11:
                    Console.WriteLine("Please enter the employee's zip code: ");
                    userInput = Console.ReadLine();
                    payroll[int.Parse(employeeIndex)].Address.ZipCode = userInput;
                    break;
                case 99:
                    break;
                default:
                    Console.WriteLine("Invalid choice!");
                    break;
            }
        }

        //function to "pay" employees
        private static void payEmployees(ref Employee[] payroll)
        {
            foreach (Employee employee in payroll)
            {
                if (employee.Address.State != "Nonesuch")
                {
                    float paycheck = Employee.Pay(employee);
                    Console.WriteLine("{0} {1} has earned ${2}.", employee.FirstName, employee.LastName, paycheck);
                }
            }
        }

    }
}
