/*
Book collection manager program
Coded by David Small on 22 March 2014
*/

#include <iostream>
#include "BookCollection.h"
#include "conio.h"

using namespace std;

int main()
{
	vector<string> bookList;			//main vector
	vector<string>::iterator myIter;	//iterator for main vector
	vector<string> displayCollection;	//vector to assure file output is correct
	char choice;

	cout << "////=====================================\\\\\\\\" << endl;
	cout << "|          Book Collection Manager          |" << endl;
	cout << "|   Coded by David Small on 22 March 2014   |" << endl;
	cout << "\\\\\\\\=====================================////" << endl;

	do
	{
		do
		{
			choice = menu();
			switch(choice)
			{
			case '1':
				addBook(bookList);
				break;
			case '2':
				removeBook(bookList, myIter);
				break;
			case '3':
				display(bookList, myIter);
				break;
			case '4':
				saveToFile(bookList, myIter);
				readFromFile(displayCollection);
				display(displayCollection, myIter);
				break;
			default:
				cout << "Invalid choice!" << endl;
				break;
			}
			cout << "Anything else (Y/N)?  ";
			cin >> choice;
			cin.ignore();
		}while(choice == 'y' || choice == 'Y');

		cleanup(bookList, displayCollection);
		cout << "Would you like to do that again (Y/N)?  ";
		cin >> choice;
		cin.ignore();
	}while (choice == 'y' || choice == 'Y');
	
	cout << endl << "Thanks for using this silly lttle thing to keep track of\nyour assuredly massive library!" << endl;
	cout << "Press ENTER to quit . . ." << endl;

	_getch();
	return 0;
}