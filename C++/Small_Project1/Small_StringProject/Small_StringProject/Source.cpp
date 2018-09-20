//Coded by David Small in coperation with Devon Thomsen
#include <iostream>
#include <conio.h>
#include "Mystring.h"

using namespace std;

int main()
{
	MyString aString  = MyString ("cauldron");
	MyString bString  = MyString("ball");
	MyString cString  = bString;
	
	
	cout << cString << endl;
	cString.Replace(1, 3, aString);
	cout << cString << endl;
	

	
	system("Pause");
	return 0;
}