//Book collection program using Book objects
//Coded by David Small on 6 April 2014

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Books
{
public:
	Books();
	Books(string title, string author, int copyrightDate);

	void setTitle(string newTitle);
	void setAuthor(string newAuthor);
	void setCopyright(string newCopyright);

	string getTitle();
	string getAuthor();
	string getCopyright();

	string toString();
	static bool Books::compareBooks(Books book1, Books book2);

	static char menu();
	static void addBook(vector<Books>& myCollection);
	static void removeBook(vector<Books>& myCollection, vector<Books>::iterator myIter);
	static void displayCollection (vector<Books>& myCollection, vector<Books>::iterator myIter);
	static void writeToFile(vector<Books>& myCollection, vector<Books>::iterator myIter);
	static void readFromFile(vector<string>& displayCollection);
	static void cleanup(vector<Books>& myCollection, vector<string>& displayCollection);

private:
	string m_title;
	string m_author;
	string m_copyrightDate;
};