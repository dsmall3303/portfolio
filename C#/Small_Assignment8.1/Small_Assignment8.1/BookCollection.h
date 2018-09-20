/*
Book collection program
Coded by David Small on 22 March 2014
*/

#include <vector>
#include <algorithm>
#include <string>

using namespace std;

char menu();
void addBook(vector<string>& bookList);
void removeBook(vector<string>& bookList, vector<string>::iterator myIter);
void display(vector<string>& bookList, vector<string>::iterator myIter);
void saveToFile(vector<string>& bookList, vector<string>::iterator myIter);
void readFromFile(vector<string>& displayCollection);
void cleanup(vector<string>& bookList, vector<string>& displayCollection);