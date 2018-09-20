#include<iostream>
#include<string>
#include<algorithm>
#include<vector>

using namespace std;

class Marker
{
public:
	Marker();
	void setData();
	string getColor();
	string getBrand();

private:
	string m_Color;
	string m_Brand;
	
};

