#include <iostream>
#include <string>
#include "Shapes.h"
#define PI 3.14159265359

using namespace std;

Geometry_Shapes::Geometry_Shapes():  //  "Member Initializer" style of constructor
	m_Area(1.0),m_Perimeter(1.0)
{
	cout << "\nInside the Shapes constructor.\n";
}

// This function sets the character identifier for the shape type.
void Geometry_Shapes::m_SetType(char typeName)
{
	m_ShapeType = typeName;
}

char Geometry_Shapes::m_GetType()
{
	return m_ShapeType;
}


// This function will calculate the area of any object based on the objType variable passed in.
// The correct formula will be run for each different object.
// For circles, a "ghost" value will need to be passed in as "secondVal"
void Geometry_Shapes::m_CalcArea(double firstVal, double secondVal, char objType)
{
	switch(objType)
	{
	case 'T':
		m_Area = 0.5*firstVal*secondVal; // area of triangle is 1/2 base * height
		break;
	case 'R':
		m_Area = firstVal*secondVal;    // area of rectangle is length * width
		break;
	case 'C':
		m_Area = PI*firstVal*firstVal;  // area of circle is PI * radius squared.  firstVal is radius.
		break;                          // secondVal will not be used here...
	default:
		m_Area = 1.0;
		cout << "\n\nAn ERROR has occurred in calculating the area.\n\n";
	}
}

// This function will calculate the perimeter of any object based on the objType variable passed in.
// The correct formula will be run for each different object.
// For circles, a "ghost" value will need to be passed in as "secondVal"
void Geometry_Shapes::m_CalcPerim(double firstVal, double secondVal, char objType, double thirdVal)
{
	switch(objType)
	{
	case 'T':
		m_Perimeter = firstVal+secondVal+thirdVal;// perimeter of triangle is sum of all sides
		break;
	case 'R':
		m_Perimeter = (2*firstVal)+(2*secondVal); // perimeter of rectangle is sum of all sides
		break;
	case 'C':
		m_Perimeter = 2*PI*firstVal;  // thre area of circle is its "circumference".
		break;                    // circumference is PI * diameter, or PI * radius * 2...
	default:
		m_Perimeter = 1.0;
		cout << "\n\nAn ERROR has occurred in calculating the area.\n\n";
	}
}

// This function is called by the circle class to set the circumference based on the perimeter.
double Geometry_Shapes::m_GetPerim()
{
	return m_Perimeter;
}

double Geometry_Shapes::m_GetArea()
{
	return m_Area;
}


MyTriangle::MyTriangle()   //  Constructor
{
	m_SetType('T');  // sets the Shape Type variable from "Geometry_Shapes"
	m_Base = 1.0;           // gives default values to base and height
	m_Height = 1.0;
	cout << "\nIn the Triangle Constructor.\n\n";
}

void MyTriangle::m_SetBase()  // prompt user to enter a value for the base of the triangle
{
	cout << "What is the length of the \"Base\" of this triangle?  ";
	cin >> m_Base;
}

void MyTriangle::m_SetHeight()  // prompt user to enter a value for the height of the triangle
{
	cout << "What is the Height of this triangle?  ";
	cin >> m_Height;
}

void MyTriangle::m_SetSides()  // prompt user to enter a value for the height of the triangle
{
	cout << "What is the length of Side A?  ";
	cin >> m_SideA;
	cout << "What is the length of Side B?  ";
	cin >> m_SideB;
	cout << "What is the length of Side C?  ";
	cin >> m_SideC;
}

double MyTriangle::m_GetBase()
{
	return m_Base;     // return out the value of the base
}

double MyTriangle::m_GetHeight()
{
	return m_Height;   // return out the value of the height
}


MyRect::MyRect()
{
	cout << "\nInside the MyRect constructor.\n";
	m_SetType('R');  // sets the Shape Type variable from "Geometry_Shapes"
	m_Length = 1.0;           // gives default values to base and height
	m_Width = 1.0;
}

void MyRect::m_SetLength()
{
	cout << "What is the length of this rectangle?  ";
	cin >> m_Length;
}

void MyRect::m_SetWidth()
{
	cout << "What is the width of this rectangle?  ";
	cin >> m_Width;
}

double MyRect::m_GetLength()
{
	return m_Length;
}

double MyRect::m_GetWidth()
{
	return m_Width;
}

void MyRect::m_Display_Data()
{
	system("pause");
	system("cls");
	cout << "\nYour Rectangle has a length of " << m_Length << ".\n";
	cout << "\nYour Rectangle has a width of " << m_Width << ".\n";
	cout << "\nYour Rectangle's area is " << m_GetArea() << ".\n";
	cout << "\nYour Rectangle's Perimeter is " << m_GetPerim() << ".\n";
	cout << "\nThat is all the data for your Rectangle.\n\n";
}

MyCircle::MyCircle()
{
	m_SetType('C');
	m_Radius = 1.0;
	m_Diameter = 1.0;
	m_Circumference = 1.0;
}

void MyCircle::m_SetRadius()
{
	cout << "What is the radius of this circle?  ";
	cin >> m_Radius;
}

double MyCircle::m_GetRadius()
{
	return m_Radius;
}

void MyCircle::m_SetCircum()
{
	m_CalcPerim(m_Radius, 1.0, 'C');
	m_Circumference = m_GetPerim();
}
