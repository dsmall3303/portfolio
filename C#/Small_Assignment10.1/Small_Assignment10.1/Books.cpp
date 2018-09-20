//Book collection program using Book objects
//Coded by David Small on 6 April 2014

#include "Books.h"
#include <iostream>
#include <vector>
#include <algorithm>
#include <iostream>
#include <fstream>

using namespace std;

//Default constructor
Books::Books()
{
	m_title = "Default Title";
	m_author = "Default Author";
	m_copyrightDate = "1991";
}

//Argumented constructor
Books::Books(string title, string author, int copyright)
{
	m_title = title;
	m_author = author;
	m_copyrightDate = copyright;
}

//Mutator method for m_title
void Books::setTitle(string newTitle)
{
	m_title = newTitle;
}

//Mutator method for m_author
void Books::setAuthor(string newAuthor)
{
	m_author = newAuthor;
}

//Mutator method for m_coryprightDate
void Books::setCopyright (string newCopyright)
{
	m_copyrightDate = newCopyright;
}

//Accessor method for m_title
string Books::getTitle()
{
	return m_title;
}

//Accessor methor for m_author
string Books::getAuthor()
{
	return m_author;
}

//Accessor method for m_copyrightDate
string Books::getCopyright()
{
	return m_copyrightDate;
}

//Method to turn a Book object into a displayable string.
string Books::toString()
{
	string output = "";
	output += m_title;
	output += ", by ";
	output += m_author;
	output += ", (c) ";
	output += m_copyrightDate;
	return output;
}

//main menu function; returns menu choice as char
char Books::menu()
{
	char choice;
	cout << endl;
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

//Function to add a new book to the collection
void Books::addBook(vector<Books>& myCollection)
{
	string title = " ";
	string author = " ";
	string copyright = " ";
	Books newBook;

	cout << endl << "What's the name of the book you want to add?" << endl;
	cout << "Enter it here:   ";
	getline(cin, title);
	newBook.setTitle(title);
	cout << endl << "Who is the author?" << endl;
	cout << "Enter the name here:   ";
	getline(cin, author);
	newBook.setAuthor(author);
	cout << endl << "What's the copyright date on that?" << endl;
	cout << "Enter it here:   ";
	getline(cin, copyright);
	newBook.setCopyright(copyright);
	myCollection.push_back(newBook);
}

//function to display the collection
void Books::displayCollection(vector<Books>& myCollection, vector<Books>::iterator myIter)
{
	string output;
	cout << endl << "Here's what you have in your collection:" << endl;
	for (myIter = myCollection.begin(); myIter != myCollection.end(); myIter++)
	{
		output = myIter->toString();	//the -> operator is used to access a property of the object a pointer is pointing to.
		cout << output << endl;
	}
}

//function to remove a book from the collection
void Books::removeBook(vector<Books>& myCollection, vector<Books>::iterator myIter)
{
	string targetBook;
	Books::displayCollection(myCollection, myIter);
	cout << endl << "What's the title of the book you want to remove?" << endl;
	cout << "Enter it here:   ";
	getline(cin, targetBook);
	for (myIter = myCollection.begin(); myIter != myCollection.end(); myIter++)		//Since the .find() function won't easily work here, I'm making my own.
	{
		if (myIter->getTitle() == targetBook)	//If the book title at position myIter matches our target, the loop stops looking and myIter retains its value
		{
			break;
		}
	}
	if (myIter == myCollection.end())
	{
		cout << "Sorry, that's not here.\nCheck the spelling and try again." << endl;
	}
	else
	{
		myCollection.erase(myIter);
	}
}

//Helper function to be called in the sorting of books into alphabetical order
bool Books::compareBooks(Books book1, Books book2)
{
	if (book1.getTitle() < book2.getTitle() )
	{
		return true;
	}
	else
	{
		return false;
	}
}

//Method to alphabetize the books and write them to an external file.
void Books::writeToFile(vector<Books>& myCollection, vector<Books>::iterator myIter)
{
	fstream myFile;
	cout << endl << "Alphabetizing and writing to file..."<< endl;
	sort(myCollection.begin(), myCollection.end(), Books::compareBooks);
	myFile.open("Advanced Book List.txt", ios::out | ios:: trunc);
	for (myIter = myCollection.begin(); myIter != myCollection.end(); myIter++)
	{
		myFile << myIter->toString() << "\n";
	}
	myFile.close();
}

//Method to read the external file into a series of strings.
//I am unsure how reading book objects back in would be accomplished.
void Books::readFromFile(vector<string>& displayCollection)
{
	fstream myFile;
	string nextBook;
	cout << endl << "Reading from file..." << endl;
	myFile.open("Advanced Book List.txt");
	while (myFile.good())
	{
		getline(myFile, nextBook);
		displayCollection.push_back(nextBook);
	}
}

//Method to clear out memory at the conclusion of the program.
void Books::cleanup(vector<Books>& myCollection, vector<string>& displayCollection)
{
	myCollection.clear();
	displayCollection.clear();
}