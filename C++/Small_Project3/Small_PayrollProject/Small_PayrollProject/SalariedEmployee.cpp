//Salaried Employee class function definition
//copied from textbook p. 541-542

#include <iostream>
#include <stdexcept>
#include "SalariedEmployee.h"

using namespace std;

SalariedEmployee::SalariedEmployee (const string &first, const string &last, const string &ssn, double salary):Employee(first, last, ssn)
{
	setWeeklySalary(salary);
}

//set salary
void SalariedEmployee::setWeeklySalary (double salary)
{
	if (salary >= 0.0)
		weeklySalary = salary;
	else
		throw invalid_argument( "Weekly salary must be >= 0.0!" );
}

//return salary
double SalariedEmployee::getWeeklySalary() const
{
	return weeklySalary;
}

//calculate earnings
//override pure virtual functions in employee
double SalariedEmployee::earnings() const
{
	return getWeeklySalary();
}

//print salaried employee's info
void SalariedEmployee::print() const
{
	cout << "Salaried employee: ";
	Employee::print(); //re-use abstract base-class function
	cout << "\nWeekly salary: " << getWeeklySalary();
}