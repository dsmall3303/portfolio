//Mystring
//Coded by David Small in cooperation with Devon Thomsen and Nick Diley

// MyString is a custom string class implementation.

#include "Mystring.h"

/*please work*/

//default constructor
MyString::MyString()
{
	//set capacity
	_capacity = 16;

	//set length
	_length = 0;

	//create string and make all elements null characters
	_string = new char [_capacity+1];
	for (int i = 0; i < _capacity; i++)
		_string[i] = '\0';
}

//constructor that takes a c-style string and makes a MyString copy of it
MyString::MyString(const char * aCString)
{
	//set capacity, defaulting to 16
	if ( strlen(aCString) > 16)
		_capacity = strlen(aCString);
	else
		_capacity = 16;

	//set length
	_length = strlen(aCString);

	//create string and copy aCString into it
	_string = new char [_capacity+1];
	strncpy(_string, aCString, strlen(aCString)+1);
}

//Constructor that takes an int argument to dertermine the size of the blank string
MyString::MyString (int numChars)
{
	//set capacity
	_capacity = numChars;

	//set length
	_length = 0;

	//create string and set each element to a null character
	_string = new char [_capacity+1];
	for (int i = 0; i < _capacity; i++)
		_string[i] = '\0';
}

//copy construstor
MyString::MyString(const MyString & original)
{
	//set capacity
	this -> _capacity = original._capacity;

	//set length
	this -> _length = original._length;

	//cpoy the other string into the new one
	this -> _string = new char [this -> _capacity+1];
	strncpy(this -> _string, original._string, strlen(original._string)+1);
}

//Destructor
MyString::~MyString()
{
	delete [] _string;
}

//Function to append a MyString onto the current MyString
void MyString:: Append(const MyString & aMyString)
{
	//Call Append and pass the rvalue's _string into it
	Append(aMyString._string);
}

//Function to append a c-style string onto the current MyString
void MyString::Append(const char * aCString)
{
	int newLength = strlen(aCString) + _length; //calculation to avoid "magic numbers"
	if (newLength > this -> _capacity)		//decide if reallocation is necessary
	{
		//copy _string into a temporary home
		char * _newStr;
		_newStr = new char [this->_length];
		strncpy(_newStr, this->_string, this->_length);

		//change the size of _string and put its original contents back in
		delete [] _string;
		this->_string = new char [newLength+1];
		strncpy(this->_string, _newStr, strlen(_newStr));

		//clean up newStr
		delete [] _newStr;
	}
		//concatenate aCstring to _string
		strncat(_string, aCString, strlen(aCString));
}

//Function to assign one MyString to another
void MyString::Assign (const MyString & aMyString)
{
	//Call Assign and pass the rvalue's _string into it
	Assign(aMyString._string);
}

//Function to assign a c-style string to a Mystring
void MyString::Assign(const char * const aCString)
{
	if (strlen(aCString) > 16)			//check for smaller-than-default capacity/length
		_capacity = strlen(aCString);	//copy capacity
	else
		_capacity = 16;					//default capacity to 16
	_length = strlen(aCString);			//copy length
	delete [] _string;					//deallocate array
	_string = new char [_capacity];		//allocate new array
	strncpy( this -> _string, aCString, strlen(aCString)); //cpoy aCstring into _string
}

//Function to return a character at a given position
char MyString::At(int index) const
{
	char target = '\0';						//placeholder for return
	try
	{
		if (index < 0)					//exeption throwing
			throw 1;
		else if (index >= _length)		//exception throwing
			throw 1;
		else
			target = _string[index];	//get the char at the indexed location
		return target;
	}
	catch (int param)						//excaption handling
	{
		std::cout << "AT_OUT_OF_RANGE_EXCEPTION";
	}
}

//Function to reset a MyString to all null characters
void MyString::Clear()
{
	for (int i = 0; i < _length; i++)	//sets all characters in the array to null
		_string[i] = '\0';
}

//Function to reset a MyString to all null characters and change its size
void MyString::Clear(int newCapacity)
{
	try
	{
		if (newCapacity < 0)						//exception throwing
			throw 5;
		else
		{
			_capacity = newCapacity;				//assign new capacity
			delete [] _string;						//deallocate array
			_string = new char [_capacity];			//allocate new array
			for (int i = 0; i < _capacity; i++)		//set new array to null chars
				_string[i] = '\0';
		}
	}
	catch (int param)								//exception handling
	{
		std::cout << "CLEAR_OUT_OF_RANGE_EXCEPTION";
	}
}

//Function to determine if one string is alphabetically greater than another
int MyString :: Compare	(const MyString & aMyString)
{
	int maxChars = _length;				//sets max number of characters to be compared
	if (aMyString._length > _length)
		maxChars = aMyString._length;	//if other string's length is higher than the invoking string's, set max characetrs to that
	return strncmp(_string, aMyString._string, maxChars);	//returns negative iff argument is a lower value than the invoking string
															//returns positive iff argument is a greater value than the invoking string
															//returns 0 iff the two strings are equal
}

//Accessor method for capacity
int MyString :: Capacity() const
{
	return _capacity;
}

//Function to check of one MyString is equal to another
bool MyString :: Equals(const MyString & aMyString) const
{
	//Call Equals and pass the rvalue's _string into it
	return this->Equals(aMyString._string);
}

//function to check of a c-style string is equal to a MyString's _string
bool MyString:: Equals(const char * const aCString) const
{
	int maxChars = _length;									//sets max number of characters to be compared
	if (strlen(aCString) > _length)
		maxChars = strlen(aCString);						//if other string's length is higher than the invoking string's, set max characetrs to that
	if ( strncmp(_string, aCString, maxChars) == 0)
		return true;
	else
		return false;
}

//Function to return the position in a string where another string starts in it
int MyString :: Find ( const MyString & aMyString ) const
{
	//set up a flag
	bool isFound = false;

	//index variable
	int i = 0;
	//loop through the string
	while (!isFound && i < strlen(this->_string))
	{
		//"catch" if the current character is equal to the first character of the substring
		if (_string[i] == aMyString._string[0])
		{
			//compare the rest of the string
			for (int k = 0; k < strlen(aMyString._string); k++)
			{
				if (_string [i] != aMyString._string[k])
					break;
				isFound = true;
			}
		}
		i++;
	}
	if (isFound)
		return i-1;
	else
		return -1;
}

//function to insert a string into the current string at a given position
void MyString :: Insert ( const MyString & aMyString, int index)
{
	int newLength = _length + aMyString._length;
	//copy _string into two temporary homes
	char * _newStr1;
	_newStr1 = new char [this->_length];
	strncpy(_newStr1, this->_string, index);

	char * _newStr2;
	_newStr2 = new char [this->_length];
	for (int i=index; i<this->_length; i++)
		_newStr2 [i] = this->_string[i];
	_newStr2 +='\0';

	//change size of _string
	delete [] _string;
	this->_string = new char [newLength+1];
	
	//copy part of _newString into _string
	strncpy(this->_string, _newStr1, index);

	//append aMyString to _string
	strncat(this->_string, aMyString._string, aMyString._length);

	//copy the rest of _newString into _string
	strncat(this->_string, _newStr2, strlen(_newStr2));

	//clean up
	delete [] _newStr1;
	delete [] _newStr2;
}

//accessor method for _length
int MyString :: Length()const
{
	return _length;
}

//function to replace a given number of characters starting at an indes with characters form another string
void MyString :: Replace ( int startIndex, int numChars, const MyString & aMyString)
{
	try
	{
		if (startIndex >= _length)					//error-throwing
			throw 20;
		else if (startIndex + numChars > _length)	//error-throwing
			throw 20;
		else if	(aMyString.Length() < numChars)		//error-throwing
			throw 20;
		else
			for (int i = 0 ; i < numChars; i++)		//replace the characters
				_string[startIndex+i] = aMyString._string[i];
	}
	catch (int param)
	{
		std::cout<<"REPLACE_OUT_OF_BOUNDS_EXCEPTION";
	}	
}


//function to return a subsection of the invoking MyString
MyString MyString::SubStr(int startIndex, int numChars) const
{
	try
	{
		if(startIndex+numChars > _length)
			throw 20;
		else
		{
			char * temp;
			temp = new char[numChars];
			for ( int i=0; i < numChars;i++)
				temp[i] = _string[startIndex+i];
			return MyString(temp);

		}
	}

	catch (int param)
	{
		std::cout << "SUBSTR_OUT_OF_BOUNDS_EXCEPTION";
	}
}

MyString MyString:: operator= (const MyString & aMyString)
{
	Assign(aMyString);
	return *this;
}

MyString MyString:: operator= (const char *  const aCString)
{
	Assign(aCString);
	return *this;
}

MyString MyString ::  operator+ (const MyString & aMyString)
{
	MyString temp (*this);
	temp.Append(aMyString);
	return temp;
}

MyString MyString :: operator+ (const char * const aCString)
{
	MyString temp (aCString);
	temp.Append(aCString);
	return temp;
}

MyString MyString :: operator+= (const MyString & aMyString)
{
	this -> Append(aMyString);
	return *this;
}

MyString MyString  :: operator+= (const char * const aCString)
{
	this -> Append (aCString);
	return *this;
}

char & MyString :: operator [] (int index) const
{
	char n = At(index);
	return n;
}

bool MyString :: operator > (const MyString & aMyString)
{
	int test = Compare(aMyString);
	if (test > 0)
		return true;
	else 
		return false;
}

bool MyString :: operator < (const MyString & aMyString)
{
	int test  = Compare(aMyString);
	if (test < 0)
		return true;
	else
		return false;
}

bool MyString :: operator >= (const MyString & aMyString)
{
	int test = Compare(aMyString);
	if (test >= 0)
		return true;
	else
		return false;
}

bool MyString :: operator <= (const MyString & aMyString)
{
	int test = Compare(aMyString);
	if (test <= 0)
		return true;
	else
		return false;
}

bool MyString :: operator == (const MyString & aMyString)
{
	return Equals(aMyString);
}

bool MyString :: operator != (const MyString & aMyString)
{
	return !(Equals(aMyString));
}

//accessor method for _string
const char* MyString :: _cstr() const
{
	return this -> _string;
}

//operator overloads for << and >>
ostream & operator << (ostream & os, const MyString & aMyString)
{
	os << aMyString._string;
	return os;
}

istream & operator >> (istream & is, MyString & aMyString)
{
	char buffer [80];
	aMyString.Clear();
	if (is.peek() != '\n')
	{
		do
		{
			is.get(buffer, 80);
			aMyString.Append(buffer);
		}while(strlen(buffer) == 79);
	}
	if (is.peek() == '\n')
		is.get();
	return is;
}