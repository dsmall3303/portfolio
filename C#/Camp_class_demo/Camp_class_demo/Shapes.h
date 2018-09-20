//#include <iostream>
//#include <string>
//#define PI 3.14159265359

//using namespace std;

class Geometry_Shapes
{
public:
	Geometry_Shapes();
	void m_SetType(char typeName);                             //  function to set the ShapeType variable
	char m_GetType();
	void m_CalcArea(double firstVal, double secondVal, char objType);
	double m_GetArea();
	void m_CalcPerim(double firstVal, double secondVal, char objType, double thirdVal=0.0);
	double m_GetPerim();
	
private:
	char m_ShapeType; // R-rectangle, T-triangle, S-square, C-circle, etc...
	double m_Area;
	double m_Perimeter;
};

/*
	Triangle class derived from "Geometry_Shapes"
	includes a default constructor, two "get" and two "set" functions
	and data members for base and height.
*/
class MyTriangle : public Geometry_Shapes
{
public:
	MyTriangle();         //  default constructor
	void m_SetBase();     //  set function for the base
	void m_SetHeight();   //  set function for the height
	double m_GetBase();   //  get function to return the base
	double m_GetHeight(); //  get function to return the height
	void m_SetSides();   //  set function for the height

private:
	double m_Base;      // data member for the length of the base of the triangle
	double m_Height;    // data member for the height of the triangle
	double m_SideA;     // data member for the length of Side A
	double m_SideB;     // data member for the length of Side B
	double m_SideC;     // data member for the length of Side C
};

/*
	Rectangle class derived from "Geometry_Shapes"
	includes a default constructor, two "get" and two "set" functions
	and data members for length and width.
*/
class MyRect : public Geometry_Shapes
{
public:
	MyRect();
	void m_SetLength();
	void m_SetWidth();
	double m_GetLength();
	double m_GetWidth();
	void m_Display_Data();

private:
	double m_Length;
	double m_Width;
};

/*
	Circle class derived from "Geometry_Shapes"
	includes a default constructor, a "set" and "get" function for radius
	and data members for length and width.
*/
class MyCircle : public Geometry_Shapes
{
public:
	MyCircle();
	void m_SetRadius();
	double m_GetRadius();
	void m_SetCircum();

private:
	double m_Radius;
	double m_Diameter;
	double m_Circumference;
};
