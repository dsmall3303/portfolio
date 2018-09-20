#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include "class.h"

using namespace std;

char menu();

int main()
{
	string userInput;
	char choice;
	vector<Marker> myMarkers;
	vector<Marker>::iterator iter;
	do
	{
		choice = menu();
		if(choice == '1')
		{
			Marker myMarker;
			myMarker.setData();
			myMarkers.push_back(myMarker);
		}
		else if(choice == '2')
		{
			for(iter = myMarkers.begin(); iter != myMarkers.end(); iter++)
			{
				cout << "Brand - " << (*iter).getBrand() << endl;
				cout << "Color - " << (*iter).getColor() << endl;
				cout << endl;
			}
		}
		else if(choice == '3')
		{
			cout << "What color marker would you like to remove?  ";
			getline(cin, userInput);

		///  ***  This is the implementation of something new called a "lambda" function
		///  ***  I am showing this only as a reference to one way this problem could be solved
		///  ***  However, I am going to recommend that for now you use the for loop shown below!!!

//			iter = find_if(myMarkers.begin(), myMarkers.end(), [userInput](Marker m_1){
//				return m_1.getColor() == userInput;});

//			myMarkers.erase(iter);

		///  ***  Use this for loop method for searching through a vector of objects!!!
			for(iter = myMarkers.begin(); iter != myMarkers.end(); iter++)
			{
				if((*iter).getColor() == userInput)
				{
					iter = myMarkers.erase(iter);
				}
			}

		}
		else if(choice == '4')
		{
			cout << endl << "Thank you!" << endl;
		}
	}while(choice != '4');

	system("pause");
	return 0;
}

char menu()
{
	char input;
	cout << endl << "1) Add Marker:" << endl;
	cout << endl << "2) Display Markers:" << endl;
	cout << endl << "3) Remove Marker:" << endl;
	cout << endl << "4) Exit program:" << endl;
	cout << "Enter Choice:  ";
	cin >> input;
	cin.ignore();
	return input;
}
