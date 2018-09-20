#include<iostream>
#include<string>
#include "class.h"

using namespace std;

Marker::Marker()
{
}

void Marker::setData()
{
	cout << "What Brand is your marker?  ";
	getline(cin, m_Brand);
	cout << "What Color is your marker?  ";
	getline(cin, m_Color);
}

string Marker::getColor()
{
	return m_Color;
}

string Marker::getBrand()
{
	return m_Brand;
}


