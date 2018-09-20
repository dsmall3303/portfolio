/*
Book collection program
Coded by David Small on 22 March 2014
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <fstream>
using namespace std;


//Function to display the main menu
char menu()
{
	char choice;
	cout << "What's it going to be, Boss?" << endl;
	cout << "1) Add book to collection" << endl;
	cout << "2) Remove book from collection" << endl;
	cout << "3) Display collection" << endl;
	cout << "4) Save to file and exit" << endl;
	cout << "Enter your choice here:  ";
	cin >> choice;
	cin.ignore();
	return choice;
}

//function to add a book to the list
void addBook(vector<string>& bookList)
{
	string newBook;
	cout << "What's the name of the book you want to add?" << endl;
	cout << "Enter it here:  ";
	getline(cin, newBook);		//stores the book title in newBook
	bookList.push_back(newBook);	//adds newBook to the end of bookList
}

//function to display the current collection
void display(vector<string>& bookList, vector<string>::iterator myIter)
{
	cout << "Here's what you have in your collection:" << endl;
	for(myIter = bookList.begin(); myIter != bookList.end(); myIter++)
	{
		cout << *myIter << endl;	//loops through the collection, displaying each title on a separate line
	}
}

//function to remove a book from the collection
void removeBook(vector<string>& bookList, vector<string>::iterator myIter)
{
	string myBook;
	display(bookList, myIter);		//just in case the collection list has been pushed off screen
	cout << "What's the name of the book you want to remove?" << endl;
	cout << "Enter it here:  " << endl;
	getline(cin, myBook);		//gets the title from the user and stores it in myBook
	myIter = find(bookList.begin(), bookList.end(), myBook);	//checks if the named title is in the list
	if (myIter == bookList.end())	//if it's not in the list, the iterator will be at the end of the vector
	{
		cout << "Sorry, that's not here.\nCheck the spelling and try again." << endl;
	}
	else
	{
		bookList.erase(myIter);
	}
}

//function to write the collection to an external file
void saveToFile(vector<string>& bookList, vector<string>::iterator myIter)
{
	fstream myStream;
	cout << "Alphabetizing and writing to file..." << endl;
	sort(bookList.begin(), bookList.end());		//alphabetizes the book list
	myStream.open("BookList.txt", ios::out | ios::trunc);	//opens BookList.txt for writing, overwriting any existing contents
	for(myIter = bookList.begin(); myIter != bookList.end(); myIter++)
	{
		myStream << *myIter << "\n";
	}
	myStream.close();
}

//function to read the external file and display its contents
void readFromFile(vector<string>& displayCollection)
{
	fstream myStream;
	string nextBook;
	cout << "Reading from file..." << endl;
	myStream.open("BookList.txt");	//opens BookList.txt for reading and writing
	while(myStream.good())		//While the file is not at its end...
	{
		getline(myStream, nextBook);	//get the next title and store it in nextBook
		displayCollection.push_back(nextBook);	//add nextBook to displayCollection
	}
}

//function to empty the vectors used in the program
void cleanup(vector<string>& bookList, vector<string>& displayCollection)
{
	bookList.clear();
	displayCollection.clear();
}