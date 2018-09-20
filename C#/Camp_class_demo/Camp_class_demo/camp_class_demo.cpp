#include <iostream>
#include <string>
#include "Shapes.h"

using namespace std;

int main()
{
	MyRect simpleRectangle;
	MyTriangle triangle1;

	simpleRectangle.m_SetLength();
	simpleRectangle.m_SetWidth();
	simpleRectangle.m_CalcArea(simpleRectangle.m_GetLength(), simpleRectangle.m_GetWidth(), simpleRectangle.m_GetType());
	simpleRectangle.m_CalcPerim(simpleRectangle.m_GetLength(), simpleRectangle.m_GetWidth(), simpleRectangle.m_GetType());
	simpleRectangle.m_Display_Data();

	system("pause");
	return 0;
}
