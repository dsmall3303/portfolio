/*
This program will act as a basic command-line calculator.
Programmed by David Small on 3 March 2014
*/

#include <iostream>
#include "conio.h"
#include "calc.h"
using namespace std;

//main function
int main()
{
	char goAgain = 'y';
	
	cout << "////=========================\\\\\\\\" << endl;
	cout << "|   Command Line Calculator     |" << endl;
	cout << "|   Programmed by David Small   |" << endl;
	cout << "\\\\\\\\=========================////"<<endl;
	cout << endl;

	double result = 0.5;
	double num1 = 0.5;
	double num2 = 0.5;
	double storedVal = 0.5;
	char calcType = 'x';
	int menuChoice = 1;
	
	while (menuChoice < 5 && menuChoice > 0)
	{
		printMenu(&menuChoice);
		
		switch(menuChoice)
		{
		case 1:
			num1 = getUserNumber();
			break;
		case 2:
			num2 = getUserNumber();
			break;
		case 3:
			storedValueManip(&storedVal, &menuChoice);
			break;
		case 4:
			calcType = getCalcType();
			result = doMath(&num1, &num2, calcType);
			displayResults(num1, num2, calcType, result);
			break;
		case 5:
			cout << "Exiting..."<<endl;
			break;
		default:
			cout << "Exiting..."<<endl;
			break;
		}

	}

	cout << "Thanks you for using this program." << endl;
	cout << "Press ENTER to exit."<<endl;
	_getch();
	return 0;
}

