//Memory class for use with CPU simulator project
//coded by David Small on 26 April 2016

package main;

public class Memory 
{
	public static byte [] eax = new byte [4];
	public static byte [] ebx = new byte [4];  
	public static byte [] ecx = new byte [4]; 
	public static byte [] edx = new byte [4]; 
	
	public static void resetRegister(byte [] reg)
	{
		for(int i = 0; i < reg.length; i++)
		{
			reg[i] = 0;
		}
	}
	
	public static String getBitString(byte [] reg)
	{
		String output = "";
		for (int i = 0; i < reg.length; i++)
		{
			output += Integer.toBinaryString(reg[i]);
		}
		return output;
	}
	
	public static void copy (byte [] arg1, byte [] arg2)
	{
		for (int i=0; i < arg1.length; i++)
		{
			arg1[i] = arg2[i];
		}
	}
}
