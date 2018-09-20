//Employee function definitions copied from textbook p. 538-539
//NB: No definitions are given for pure virtual functions
#include <iostream>
#include "Employee.h"

using namespace std;

//constructor
Employee::Employee( const string &first, const string &last, const string &ssn)
{
	firstName = first;
	lastName = last;
	SSN = ssn;
}

//set first name
void Employee::setFirstName(const string &first)
{
	firstName = first;
}

//get first name
string Employee::getFirstName() const
{
	return firstName;
}

//set Last Name
void Employee::setLastName(const string &last)
{
	lastName = last;
}

//get last name
string Employee::getLastName() const
{
	return lastName;
}

//set social security number
void Employee::setSSN(const string &ssn)
{
	SSN = ssn;
}

//get Social security number
string Employee::getSSN() const
{
	return SSN;
}

//set birthdate
void Employee::setBirthdate (Date &d)
{
	birthdate = d;
}

//get birthate
Date Employee::getBirthdate() const
{
	return birthdate;
}

void Employee::print() const
{
	cout << getFirstName() << ' ' << getLastName() << "\nSocial Security Number: " << getSSN() << "\nBirthdate: " << getBirthdate();
}