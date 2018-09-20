//Employee salary program
//Originally coded by David Small on 20 July 2014 in C#
//Ported to C++ by David Small on 4 December 2014
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <conio.h>
#include "Date.h"
#include "Employee.h"
#include "SalariedEmployee.h"
using namespace std;



int main ()
{
	vector <SalariedEmployee> payroll;
	vector <SalariedEmployee>::iterator payIter;
	string firstName = "";
	string lastName = "";
	string social = "";
	int bmonth = 0;
	int bday = 0;
	int byear = 0;
	double salary = 0.0;
	char goAgain = 'y';
	Date now(4, 2, 2014);
	int employeeMonth = 0;

	do
	{
		//get elements needed to build employee
		cout << "Please enter the employee's  first name:\n";
		cin >> firstName;
		cin.ignore();
		cout << endl;

		cout << "Please enter the employee's last name:\n";
		cin >> lastName;
		cin.ignore();
		cout << endl;

		cout << "Please enter the employee's ten-digit social security number:\n";
		cin >> social;
		cin.ignore();
		cout << endl;

		cout << "Please enter the employee's salary in dollars:\n";
		cin >> salary;
		cin.ignore();

		cout << "Please enter the employee's birth month (1 to 12):\n";
		cin >> bmonth;
		cin.ignore();
		cout << endl;

		cout << "Please enter the employee's birth day (1 to 31 as appropriate):\n";
		cin >> bday;
		cin.ignore();
		cout << endl;

		cout << "Please enter the employee's birth year (1900 to 2100 only):\n";
		cin >> byear;
		cin.ignore();
		cout << endl;

		Date bdate(bmonth, bday, byear);	//build birthdate
		SalariedEmployee temp(firstName, lastName, social, salary);	//build employee
		temp.setBirthdate(bdate);

		payroll.push_back(temp);	//add employee to payroll

		cout << "Would you like to add another employee to the payroll (y/n)?\n";
		cin >> goAgain;
		cin.ignore();
		cout << endl;

		//temp.print();
	}while (goAgain == 'y' || goAgain == 'Y');

	cout << "Beginning simulation:\n";
	cout << endl << now << ": \n";
	payIter = payroll.begin();
	for (payIter; payIter != payroll.end(); payIter++)
	{
		employeeMonth = payIter -> getBirthdate().getMonth();
		if (employeeMonth == now.getMonth())
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << (payIter -> getWeeklySalary() *4) + 100.0 << " this month.\n";
		else
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << payIter -> getWeeklySalary() *4 << " this month.\n";
	}

	now.setDate(5, 2, 2014);
	cout <<endl << now << ": \n";
	payIter = payroll.begin();
	for (payIter; payIter != payroll.end(); payIter++)
	{
		employeeMonth = payIter -> getBirthdate().getMonth();
		if (employeeMonth == now.getMonth())
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << (payIter -> getWeeklySalary() *4) + 100.0 << " this month.\n";
		else
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << payIter -> getWeeklySalary() *4 << " this month.\n";
	}

	now.setDate(6, 2, 2014);
	cout << endl << now << ": \n";
	payIter = payroll.begin();
	for (payIter; payIter != payroll.end(); payIter++)
	{
		employeeMonth = payIter -> getBirthdate().getMonth();
		if (employeeMonth == now.getMonth())
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << (payIter -> getWeeklySalary() *4) + 100.0 << " this month.\n";
		else
			cout << payIter -> getFirstName() << " " << payIter -> getLastName() << " has earned $" << payIter -> getWeeklySalary() *4 << " this month.\n";
	}
	_getch();
	return 0;
}	