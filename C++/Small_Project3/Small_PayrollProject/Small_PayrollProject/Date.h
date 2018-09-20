//Date class header file copied from textbook p.446-447
#ifndef DATE_H
#define DATE_H

#include <array>
#include <iostream>

class Date
{
	friend std::ostream &operator << (std::ostream &, const Date &);
public:
	Date (int m=1, int d=1, int y=1900);
	void setDate (int, int, int);		//set month, day, year
	Date &operator++();					//prefix increment operator
	Date operator++(int);				//postfix increment operator
	Date &operator += (unsigned int);	//add days, modify object
	static bool isLeapYear(int);		//is date a leap year?
	bool isEndOfMonth(int) const;		//is the date the end of a month?
	int getMonth();
	int getDay();
	int getYear();
private:
	unsigned int month;
	unsigned int day;
	unsigned int year;
	static const std::array<unsigned int, 13 > days;	//days per month
	void helpIncrement();								//utility function for incrementing date
};
#endif