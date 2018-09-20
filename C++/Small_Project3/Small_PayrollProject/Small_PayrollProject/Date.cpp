//Date class function definition file copied from textbook p. 447-449
#include <iostream>
#include <string>
#include "Date.h"
using namespace std;

//initialize static data member; once classwide copy
const array<unsigned int, 13 > Date::days = 
	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

Date::Date( int month, int day, int year)
{
	setDate(month, day, year);
}

void Date::setDate(int mm, int dd, int yy )
{
	if (mm >= 1 && mm <= 12)
		month = mm;
	else
		throw invalid_argument("Month must be between 1 and 12!");

	if (yy >= 1900 && yy <= 2100)
		year = yy;
	else
		throw invalid_argument("Year must be between 1900 and 2100!");

	//test for a leap year
	if ((month == 2 && isLeapYear(year) && dd >= 1 && dd <= 29) || (dd >= 1 && dd <= days[month]))
		day = dd;
	else
		throw invalid_argument("Day is out of range for current month and year!");
}

//overload prefix increment operator
Date &Date::operator++ ()
{
	helpIncrement();	//increment date
	return *this;		//reference return to create an lvalue
}

//overload postfix operator
//note that the dummy integer parameter does not have a parameter name
Date Date::operator++(int)
{
	Date temp = *this;		//hold current state of object
	helpIncrement();

	//return unincremented, saved, temporary object
	return temp;   //value return not reference return
}

//add specified number of days to date
Date &Date::operator+=(unsigned int moreDays)
{
	for ( int i=0; i < moreDays; ++i)
		helpIncrement();

	return *this; //enables cascading
}

//if the year is a leap year, return true
bool Date::isLeapYear (int testYear)
{
	if (testYear % 400 == 0 || (testYear % 100 != 0 && testYear % 4 == 0))
		return true;	//a leap year
	else
		return false;	//not a leap year
}

//determine whether the day is the last of the month
bool Date::isEndOfMonth (int testDay) const
{
	if (month == 2 && isLeapYear(year))
		return testDay == 29;	//last day of February in a leap year
	else
		return testDay == days[month];
}

//function to help increment the date
void Date::helpIncrement()
{
	//not end of month
	if (!isEndOfMonth(day))
		++day;
	else
		if (month < 12)		//day is end of month and month < 12
		{
			++month;
			day = 1;		//first day of new month
		}
		else                //last day of year
		{
			++year;
			month = 1;
			day = 1;
		}
}

//overloaded output operator
ostream &operator << (ostream &output, const Date &d)
{
	static string monthName [13] = {"Smarch", "January", "February", "March", "April", "May", "June", "July", "August",
		"September", "October", "November", "December"};
	output << monthName[d.month] << ' '<< d.day << ", "<< d.year;
	return output;	//enables cascading
}

int Date::getMonth()
{
	return month;
}

int Date::getDay()
{
	return day;
}

int Date::getYear()
{
	return year;
}