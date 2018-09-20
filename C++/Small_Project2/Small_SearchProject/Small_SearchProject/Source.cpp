//recursive binary search algorithm
//N.B: THIS WILL NOT WORK ON UNSORTED ARRAYS
#include <iostream>
#include <conio.h>
#include <array>
#include <cstdlib>
using namespace std;

template <typename T, size_t size>
int bsearch (const array <T, size> &items, int target)
{
	return bsearch(items, target, 0, items.size()-1);
}

template <typename T, size_t size>
int bsearch (const array <T, size> &list, int target, int first, int last)
{
	if ( first <= last)
	{
		int mid = first + ((last - first)/2);
		if( list[mid] == target)
			return mid;
		else if (list[mid] > target)
			return bsearch(list, target, first, mid-1);
		else
			return bsearch(list, target, mid+1, last);
	}
	return -1;
}

int main()
{
	int target = 0;
	int index = 0;
	const size_t arraySize = 10;
	array<int, arraySize> serArray;
	for (int i = 0; i < serArray.size(); i++)
	{
		serArray[i] = i;
	}
	for (int i = 0; i < serArray.size(); i++)
	{
		cout<< serArray[i] << endl;
	}
	cout << endl << "What number to you want to search for?   ";
	cin >> target;
	cin.clear();

	index = bsearch(serArray, target);
	if (index != -1)
	{
		cout << "Target number " << target << " found at index " << index << ".\n";
	}
	else
	{
		cout << "The specified number was not found.\n";
	}

	_getch();
	
	return 0;
}