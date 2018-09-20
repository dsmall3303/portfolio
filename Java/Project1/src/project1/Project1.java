package project1;

import java.util.Scanner;

public class Project1 
{
	public static void main(String[] args)
	{
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int sum = 0;
		int product = 0;
		int largest = 0;
		int smallest = 0;
		float average = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a whole number: ");
		num1 = in.nextInt();
		//System.out.printf("int1: %d\n", num1);
		System.out.print("Please enter a second whiole number: ");
		num2 = in.nextInt();
		//System.out.printf("int2: %d%n", num2);
		System.out.print("Please enter a third number: ");
		num3 = in.nextInt();
		//System.out.printf("int3: %d%n", num3);
		
		sum = num1 + num2 + num3;
		System.out.printf("The sum of the numbers is %d.%n", sum);
		
		average = (float)sum/(float)3;
		System.out.printf("The average of the numbers is %.2f%n", average);
		
		product = num1 * num2 * num3;
		System.out.printf("The product of the numbers is %d%n", product);
		
		largest = num1;
		if(num2 > largest)
		{
			largest = num2;
		}
		if(num3 > largest)
		{
			largest = num3;
		}
		System.out.printf("The largest of the numbers is %d%n", largest);
		
		smallest = num1;
		if(num2 < smallest)
		{
			smallest = num2;
		}
		if(num3 < smallest)
		{
			smallest = num3;
		}
		System.out.printf("The smallest of the numbers is %d%n", smallest);
		
		in.close();
	}

}
