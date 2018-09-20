/*Temperature Conversion Calculator
This program will prompt the user for a temperature in either Celsius or Fahernheit
and print out the temerature as the other type.
*/

#include <iostream>
#include "conio.h"

using namespace std;

int main()
{
	int userTemp = 0;
	int convertedTemp = 0;
	char tempType = 'q';
	char goAgain = 'y';
	bool isTempType = false;

	cout << "////======================================\\\\\\\\" << endl;
	cout << "|    Temperature Conversion program v.0.1    |" << endl;
	cout << "|            Coded by David Small            |" << endl;
	cout << "\\\\\\\\======================================////" << endl;

	while (goAgain == 'y' || goAgain == 'Y')
	{
		cout << "Please enter a temperature: ";
		cin >> userTemp;									//ideally some form of sanity check would be performed here to ensure the user entered an int
		cin.clear();
		do
		{
			cout << "Is that Fahrenheit (F) or Celsius (C)?  ";
			cin >> tempType;								//get initial scale from user
			cin.clear();
			//cout << "\n";

			if (tempType == 'F' || tempType == 'f')			//if the user's entry is in Fahrenheit, use this
			{
				
				convertedTemp = ((userTemp - 32) * 5) / 9;	//Fahrenheit -> Celsius
				cout<<"In Celcius, that is " << convertedTemp << " degrees.\n";
				isTempType = true;								//exit loop
			}
			else if (tempType == 'C' || tempType == 'c')	//If the user's entry is Celsius, use this.
			{
				convertedTemp = 32 + ((9*userTemp)/5);		//Celsius -> Fahrenheit
				cout << "In Fahrenheit, that is " << convertedTemp << " degrees.\n";
				isTempType = true;							//exit loop
			}
			else
			{
															//Default case: error message and ask again
				cout <<"That is not a valid temperature type.\nPlease enter a valid temperature type.";
			}
		} while (!isTempType);

		cout << "Would you like to enter another temperature? (y/n)   ";	//ask the user if they want to use program again w/o quitting.
		cin >> goAgain;
		cin.clear();
	}

	cout << "Thanks for using this temperature conversion program.\n";
	cout <<	"Have a nice day!\n";
	cout <<	"Press ENTER to quit.\n";


	_getch();
	return 0;
}