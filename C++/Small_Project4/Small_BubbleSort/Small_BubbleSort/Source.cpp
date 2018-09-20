//Bubble sort implementation
//Coded by David Small on 11 December 2014
#include <iostream>
#include <conio.h>
#include <time.h>
using namespace std;


int main()
{
	bool sorted = false;
	int index = 0;
	srand(time(NULL));			//seed the random number generator using the system time
	const int ARRAY_MAX = 50;	//set the max number of ints in the array

	int mainArray [ARRAY_MAX];

	for (int i = 0; i < ARRAY_MAX; i++)
		mainArray[i] = rand()%501;		//set each of the numbers in mainArray to a number between 0 and 50.

	cout << "Before sort:\n";
	for (int i = 0; i < ARRAY_MAX; i++)
		cout << mainArray[i] << " ";
	cout << endl;

	while (!sorted)				//main sorting loop
	{
		sorted = true;			//if the following conditions are never met, then the array is sorted
		for (int c = 0 ; c < ARRAY_MAX-1; c++)
		{
			if (mainArray[c] > mainArray[c+1])	//if the current index is larger than the item after the index, take action
			{
				sorted = false;					//we are changing something, so the array is not sorted
				int temp = 0;					//temporary variable for switching purposes
				temp = mainArray[c];			//switch the current item with the one after it.
				mainArray[c] = mainArray[c+1];
				mainArray[c+1] = temp;
			}
		}

		/*for (int c=0; c < ARRAY_MAX; c++)
			cout << mainArray[c]<< " ";
		cout << endl;*/
	}

	cout << "\nAfter sort:\n";
	for (int i = 0; i < ARRAY_MAX; i++)
		cout << mainArray[i] << " ";
	cout << endl;



	cout << "Press ENTER to continue...\n";
	_getch();
	return 0;
}

