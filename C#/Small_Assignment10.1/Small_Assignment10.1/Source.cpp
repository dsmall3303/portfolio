//Book collection program using Book objects
//Coded by David Small on 6 April 2014

#include "Books.h"
#include "conio.h"
#include <iostream>

using namespace std;

int main()
{
	vector<Books> myCollection;			//main vector
	vector<Books>::iterator myIter;	//iterator for main vector
	vector<string> displayCollection;	//vector to assure file output is correct
	vector<string>::iterator displayIter;
	char choice;

	cout << "////====================================\\\\\\\\" << endl;
	cout << "|          Book Collection Manager         |" << endl;
	cout << "|   Coded by David Small on 6 April 2014   |" << endl;
	cout << "\\\\\\\\====================================////" << endl;

	do
	{
		do
		{
			choice = Books::menu();
			switch(choice)
			{
			case '1':
				Books::addBook(myCollection);
				break;
			case '2':
				Books::removeBook(myCollection, myIter);
				break;
			case '3':
				Books::displayCollection(myCollection, myIter);
				break;
			case '4':
				Books::writeToFile(myCollection, myIter);
				Books::readFromFile(displayCollection);
				cout << "Here's what you have in your collection:" << endl;
				for (displayIter = displayCollection.begin(); displayIter != displayCollection.end(); displayIter++)
				{
					cout << *displayIter << endl;
				}
				break;
			default:
				cout << "Invalid choice!" << endl;
				break;
			}
			cout << endl << "Anything else (Y/N)?  ";
			cin >> choice;
			cin.ignore();
		}while(choice == 'y' || choice == 'Y');

		Books::cleanup(myCollection, displayCollection);
		cout << endl << "Would you like to do that again (Y/N)?  ";
		cin >> choice;
		cin.ignore();
	}while (choice == 'y' || choice == 'Y');
	
	cout << endl << "Thanks for using this silly lttle thing to keep track of\nyour assuredly massive library!" << endl;
	cout << endl << "Press ENTER to quit . . ." << endl;

	_getch();
	return 0;
}