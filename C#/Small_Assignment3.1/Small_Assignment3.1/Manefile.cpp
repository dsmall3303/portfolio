/*
this program will provide a simple demonstration of array manipulation
using user input and/or random numbers.
Coded by David Small on February 1 2014
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include "conio.h"
using namespace std;

int main()
{
	const int MAX_ARRAY_COLS = 4;
	const int LOW_VAL = 0;
	const int HIGH_VAL = 10;
	const int RANGE = HIGH_VAL - LOW_VAL;

	bool allDone = false;
	double userNum = 0.0;
	double temp = 0.0;
	double numArray1[MAX_ARRAY_COLS];
	double numArray2[MAX_ARRAY_COLS];
	double numArray3[MAX_ARRAY_COLS];
	char manualEntry = 'q';
	char userDone = 'q';


	cout << "////====================\\\\\\\\" << endl;
	cout << "|   Array Demo Program     |" << endl;
	cout << "|   Coded by David Small   |" << endl;
	cout << "|   on February 1, 2014    |" << endl;
	cout << "\\\\\\\\====================////" << endl;


	do
	{
		cout << "Would you like to manually enter numbers (y/n)?   ";
		cin >> manualEntry;
		cin.ignore();
		if (manualEntry == 'y' || manualEntry == 'Y')
		{
			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				cout << "Please enter a number:   ";
				cin >> userNum;
				cin.ignore();
				numArray1[n] = userNum;
			}

			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				cout << "Please enter a number:   ";
				cin >> userNum;
				cin.ignore();
				numArray2[n] = userNum;
			}

			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				numArray3[n] = numArray1[n] + numArray2[n];
				cout << numArray1[n] << " + " << numArray2[n] << " = " << numArray3[n] << endl;
			}

			cout << "Would you like to do that again (y/n)?   ";
			cin >> userDone;
			cin.ignore();
			if (userDone == 'n' || userDone == 'N')
			{
				allDone = true;
			}
			else if (userDone == 'y' || userDone == 'Y')
			{
				allDone = false;
			}
			else
			{
				cout << "Sorry, I didn't understand that.\n";
				allDone = false;
			}
		}
		else if (manualEntry == 'n' || manualEntry == 'N')
		{
			srand(time(0));
			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				temp = (rand() % RANGE) + LOW_VAL;
				numArray1[n] = temp;
			}

			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				temp = (rand() % RANGE) + LOW_VAL;
				numArray2[n] = temp;
			}

			for (int n = 0; n < MAX_ARRAY_COLS; n++)
			{
				numArray3[n] = numArray1[n] + numArray2[n];
				cout << numArray1[n] << " + " << numArray2[n] << " = " << numArray3[n] << endl;
			}

			cout << "Would you like to do that again (y/n)?   ";
			cin >> userDone;
			cin.ignore();
			if (userDone == 'n' || userDone == 'N')
			{
				allDone = true;
			}
			else if (userDone == 'y' || userDone == 'Y')
			{
				allDone = false;
			}
			else
			{
				cout << "Sorry, I didn't understand that.\n";
				allDone = false;
			}
		}
		else
		{
			cout << "Sorry, I didn't understand that.\n";
			allDone = true;
		}
	} while (allDone == false);

	cout << "Thanks for using this program!\nHave a great day!\n";
	getch();
	return 0;
}