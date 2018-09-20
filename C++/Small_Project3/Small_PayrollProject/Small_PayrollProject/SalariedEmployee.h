//SalariedEmployee derived class copied from textbook p. 540

#ifndef SALARIED_H
#define SALARIED_H

#include<string>
#include "Employee.h"

class SalariedEmployee : public Employee
{
public:
	SalariedEmployee(const std::string &, const std::string &, const std::string &, double = 0.0);
	virtual ~SalariedEmployee() {}				//virtual destructor

	void setWeeklySalary (double);				//sets weekly salary
	double getWeeklySalary() const;				//gets weekly salary

	//keyword virtual signals intent to override
	virtual double earnings() const override;	//calculate earnings
	virtual void print() const override;		//print object
	
private:
	double weeklySalary;
};

#endif