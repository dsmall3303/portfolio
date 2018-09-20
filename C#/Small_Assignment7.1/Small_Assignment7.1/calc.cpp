#include <iostream>
using namespace std;

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

double doMath(double* pNum1, double* pNum2, char calcSymbol)		//function to perform math
{
	double result = 0.0;

	switch (calcSymbol)
	{
	case '+':					//addition
		result = *pNum1 + *pNum2;
		break;
	case '-':					//subtraction
		result = *pNum1 - *pNum2;
		break;
	case '*':					//multiplication
		result = *pNum1 * *pNum2;
		break;
	case '/':					//division
		if (*pNum2 != 0)			//check for division by 0
		{
			result = *pNum1 / *pNum2;
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

void displayResults(double& rNum1, double& rNum2, char calcSymbol, double& rResult)	//function to display rexults
{
	cout << rNum1 << " " << calcSymbol << " " << rNum2<< " = " << rResult << endl;
}

char getGoAgain()	//finction to check if the user wants to perform another operation
{
	char temp = 'q';
	cout << "Would you like to perfrom another calculation (y/n)?";
	cin >> temp;
	return temp;
}

//Function to allow for a single stored value
void storedValueManip(double* storedValue, int* menuChoice)
{
	cout<<"1) Store Value"<<endl;
	cout<<"2) Retrieve Value"<<endl;
	cout<<"3) Clear Value"<<endl;
	cout<<"Please enter your choice on the line below:"<<endl;
	cin >> *menuChoice;

	switch(*menuChoice)
	{
	case 1:
		*storedValue = getUserNumber();
		break;
	case 2:
		cout<<"The stored value is "<<*storedValue<<endl;
		break;
	case 3:
		*storedValue = 0.5;
		break;
	default:
		cout << "Never mind then..."<<endl;
		break;
	}
}

//main menu function
void printMenu(int* menuChoice)
{
	cout << "Please choose one of the following:"<<endl;
	cout << "1) Enter value 1" <<endl;
	cout << "2) Enter value 2" <<endl;
	cout << "3) Access number storage" <<endl;
	cout << "4) Perform an operation" <<endl;
	cout << "5) Quit" << endl;
	cout << "Please enter your choice on the line below:"<<endl;
	cin >> *menuChoice;
}