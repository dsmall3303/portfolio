//Employe base class copied from textbook p.538
#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>
#include "Date.h"

class Employee
{
public:
	Employee(const std::string &, const std::string &, const std::string &);
	virtual ~Employee(){}						//virtual destructor

	void setFirstName( const std::string & );	//set first name
	std::string getFirstName() const;			//get first name

	void setLastName(const std::string &);		//set last name
	std::string getLastName() const;			//set last name

	void setSSN(const std::string &);			//set Social Security Number
	std::string getSSN() const;					//get SSN

	void setBirthdate (Date &);
	Date getBirthdate() const;

	//pure virtual function make Employee an abstract base class
	virtual double earnings() const = 0;		//pure virtual
	virtual void print() const;					//virtual

private:
	std::string firstName;
	std::string lastName;;
	std::string SSN;
	Date birthdate;
};

#endif