/*
This program will act as a basic command-line calculator.
Programmed by David Small on 16 February 2014
*/

#include <iostream>
#include "conio.h"
using namespace std;

//function prototypes
double getUserNumber();
char getCalcType();
//double doAddition(double num1, double num2);
//double doSubtraction(double num1, double num2);
//double doMultiplication(double num1, double num2);
//double doDivision(double num1, double num2);
double doMath(double num1, double num2, char calcSymbol);
void displayResults(double num1, double num2, char calcSymbol, double result);
char getGoAgain();

//main function
int main()
{
	char goAgain = 'y';
	
	cout << "////=========================\\\\\\\\" << endl;
	cout << "|   Command Line Calculator     |" << endl;
	cout << "|   Programmed by David Small   |" << endl;
	cout << "\\\\\\\\=========================////"<<endl;
	cout << endl;

	while (goAgain == 'y' || goAgain == 'Y')
	{
		double result = 0.0;
		double num1 = getUserNumber();
		char calcType = getCalcType();
		double num2 = getUserNumber();
		
		result = doMath(num1, num2, calcType);

		displayResults(num1, num2, calcType, result);
		goAgain = getGoAgain();
	}

	cout << "Thanks you for using this program." << endl;
	cout << "Press ENTER to exit."<<endl;
	_getch();
	return 0;
}

double getUserNumber()		//function to get user input
{
	double temp = 0.5;
	cout << "Please enter a number: ";
	cin >> temp;
	return temp;
}

char getCalcType()		//function to determine what sort of operation is being performed
{
	char temp  = 'x';
	cout << "What type of operation do you wish to perform?" << endl;
	cout << "Addition (+), Subtraction (-), Multiplication (*), or Division (/)?" << endl;
	cout << "Please enter your choice on the line below:"<<endl;
	cin >> temp;
	return temp;
}

double doMath(double num1, double num2, char calcSymbol)		//function to perform math
{
	double result = 0.0;
	switch (calcSymbol)
	{
	case '+':					//addition
		result = num1 + num2;
		break;
	case '-':					//subtraction
		result = num1 - num2;
		break;
	case '*':					//multiplication
		result = num1 * num2;
		break;
	case '/':					//division
		if (num2 != 0)			//check for division by 0
		{
			result = num1 / num2;
		}
		else
		{
			cout << "Cannot divide by 0!" << endl;
		}
		break;
	default:					//error case
		cout << "I'm sorry, that doesn't seem to be a valid operator..." << endl;
		break;
	}
	return result;

}

/*
double doAddition(double num1, double num2)		//function to perform addition
{
	double result = num1 + num2;
	return result;
}
*/

/*
double doSubtraction(double num1, double num2)	//function to perform multiplication
{
	double result = num1 - num2;
	return result;
}
*/

/*
double doMultiplication(double num1, double num2)	//function to perform multiplicaiton
 {
	 double result = num1 * num2;
	 return result;
 }
 */

/*
double doDivision(double num1, double num2)		//function to perform division
{
	double result = 0.0;
	if (num2 != 0)		//sanity check to avoid division by 0
	{
		result = num1 / num2;
	}
	else
	{
		cout << "Cannot divide by 0!" << endl;
	}
	return result;
}
*/

void displayResults(double num1, double num2, char calcSymbol, double result)	//function to display rexults
{
	cout << num1 << " " << calcSymbol << " " << num2<< " = " << result << endl;
}

char getGoAgain()	//finction to check if the user wants to perform another operation
{
	char temp = 'q';
	cout << "Would you like to perfrom another calculation (y/n)?";
	cin >> temp;
	return temp;
}