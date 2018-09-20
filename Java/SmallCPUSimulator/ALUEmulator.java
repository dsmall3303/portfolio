//ALU emulator coded by David Small on 27 February 2016
//re-coded by David Small on 26 April 2016

package main;

import java.nio.ByteBuffer;

public class ALUEmulator 
{
//	//Scanner gets input from system and files
//	//static Scanner input = new Scanner(System.in);
//	
//	//used to hold instructions before converting to hex values
//	static int intIn;
//	static int tempOut;
//	
//	//used to hold operands and opcodes after converting to hex values
//	static String opHexCode = "";
//	static String opcode = "";
//	static String operandA = "";
//	static String operandB = "";
//	static String tempStr = "";
//	
//	static String output = "";
//	
//	static String padHelper = "";
//	
//	public static void ALULoop()
//	{
//		//while opcode is not stop
//		while(opcode != "stop")
//		{
//		//get next opcode
//			for (int i = 0; i <=1; i++)
//			{
//				//intIn = input.nextByte();
//				opHexCode += Integer.toHexString(intIn);
//			}
//			opcode = hexToChar(opHexCode);
//			opcode.toLowerCase();
//			opHexCode = "";
//			
//			//if the opcode is not "or", then it is three characters long
//			if(opcode != "or")
//			{
//				//intIn = input.nextByte();
//				opHexCode += Integer.toHexString(intIn);
//				opHexCode += hexToChar(opHexCode);
//			}
//			
//			//output opcode for debugging
//			System.out.println("opcode: "+opcode);
//			
//			//read in first operand
//			//if (input.hasNextByte())
//			{
//				//intIn = input.nextByte();
//				operandA = Integer.toHexString(intIn);
//				System.out.println("operand A: " + operandA);
//			}
//			
//			//if opcode is not "not," read second operand
//			if (opcode != "not")
//			{
//				//if (input.hasNextByte())
//				{
//					//intIn = input.nextByte();
//					operandB = Integer.toHexString(intIn);
//					System.out.println("operand B: " + operandB);
//				}
//			}
//				
//			//Switch on opcode
//			switch(opcode)
//			{
//			case "add":
//				//add operands together
//				tempOut = Integer.parseInt(operandA, 16) + Integer.parseInt(operandB, 16);
//				
//				//put into output
//				output = Integer.toString(tempOut);
//				
//				//display output to std out
//				System.out.println(output);
//				
//				break;
//				
//			case "sub":
//				//subtract operand b from operand a
//				tempOut = Integer.parseInt(operandA, 16) - Integer.parseInt(operandB, 16);
//				
//				//put into output
//				output = Integer.toString(tempOut);
//				
//				//display to std out
//				System.out.println(output);
//				
//				break;
//				
//			case "and":
//				//convert operands to binary
//				operandA = Integer.toBinaryString(Integer.parseInt(operandA, 16));
//				
//				operandB = Integer.toBinaryString(Integer.parseInt(operandB, 16));
//				
//				//if a is shorter than b, pad it with zeroes to the nearest multiple of 8
//				if (operandA.length() < operandB.length())
//				{
//					int diff = operandB.length() - operandA.length();
//					while (diff % 8 != 0)
//					{
//						diff++;
//					}
//					for (int i=0; i < diff; i++)
//					{
//						padHelper = '0' + operandA;
//						operandA = padHelper;
//					}
//				}
//				
//				//if b is shorter than a, pad it with zeroes to the nearest multiple of 8
//				else if (operandB.length() < operandA.length())
//				{
//					int diff = operandA.length() - operandB.length();
//					while (diff % 8 != 0)
//					{
//						diff++;
//					}
//					for (int i=0; i < diff; i++)
//					{
//						padHelper = '0' + operandB;
//						operandB = padHelper;
//					}
//				}
//				//bitwise and on operands
//				for(int i = 0; i < operandA.length(); i++)
//				{
//					if((operandA.substring(i, i+1) == "1") && (operandB.substring(i, i+1) == "1"))
//					{
//						tempStr += '1';
//					}
//					else
//					{
//						tempStr += '0';
//					}
//				}
//				//put into output
//				tempOut = Integer.parseInt(tempStr, 2);
//				output = Integer.toString(tempOut);
//				
//				//display to std out
//				System.out.println(output);
//				break;
//			case "or":
//				//convert operands to binary
//				operandA = Integer.toBinaryString(Integer.parseInt(operandA, 16));
//				
//				operandB = Integer.toBinaryString(Integer.parseInt(operandB, 16));
//				
//				//if a is shorter than b, pad it with zeroes to the nearest multiple of 8
//				if (operandA.length() < operandB.length())
//				{
//					int diff = operandB.length() - operandA.length();
//					while (diff % 8 != 0)
//					{
//						diff++;
//					}
//					for (int i=0; i < diff; i++)
//					{
//						padHelper = '0' + operandA;
//						operandA = padHelper;
//					}
//				}
//				
//				//if b is shorter than a, pad it with zeroes to the nearest multiple of 8
//				else if (operandB.length() < operandA.length())
//				{
//					int diff = operandA.length() - operandB.length();
//					while (diff % 8 != 0)
//					{
//						diff++;
//					}
//					for (int i=0; i < diff; i++)
//					{
//						padHelper = '0' + operandB;
//						operandB = padHelper;
//					}
//				}
//				//bitwise or on operands
//				for(int i = 0; i < operandA.length(); i++)
//				{
//					if((operandA.substring(i, i+1) == "1") || (operandB.substring(i, i+1) == "1"))
//					{
//						tempStr += '1';
//					}
//					else
//					{
//						tempStr += '0';
//					}
//				}
//				//put into output
//				tempOut = Integer.parseInt(tempStr, 2);
//				output = Integer.toString(tempOut);
//				
//				//display to std out
//				System.out.println(output);
//				break;
//			case "not":
//				//convert operand to binary
//				operandA = Integer.toBinaryString(Integer.parseInt(operandA, 16));
//				
//				//bitwise not
//				for (int i = 0; i < operandA.length(); i++)
//				{
//					if (operandA.charAt(i) == '0')
//					{
//						tempStr += '1';
//					}
//					else
//					{
//						tempStr += '0';
//					}
//				}
//				//put into output
//				tempOut = Integer.parseInt(tempStr, 2);
//				output = Integer.toString(tempOut);
//				
//				//display to std out
//				System.out.println(output);
//				break;
//			default:
//				break;
//			}
//			
//		}
//	}
	
	//method to add values
	public static void Add (byte [] destination, String source)
	{
		int temp1;
		int temp2;
		int temp3; 											//temporary storage
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		temp1 = intBuff.getInt();							//convert byte array to int
		temp2 = Integer.parseInt(source);						//convert string to int
		temp3 = temp1 + temp2;								//add ints
		arrayBuff.putInt(temp3);							//convert result to byte array
		
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	public static void Add (byte [] destination, byte [] source)
	{
		int temp1;
		int temp2;
		int temp3; 											//temporary storage
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffers to convert int to byte array
		ByteBuffer intBuff1 = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		ByteBuffer intBuff2 = ByteBuffer.wrap(source);
		temp1 = intBuff1.getInt();							//convert byte array to int
		temp2 = intBuff2.getInt();						//convert string to int
		temp3 = temp1 + temp2;								//add ints
		arrayBuff.putInt(temp3);							//convert result to byte array
		
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//method to subtract values
	public static void Sub (byte [] destination, String source)
	{
		int temp1;
		int temp2;
		int temp3; 											//temporary storage
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		temp1 = intBuff.getInt();							//convert byte array to int
		temp2 = Integer.parseInt(source);					//convert string to int
		temp3 = temp1 - temp2;								//subtract ints
		arrayBuff.putInt(temp3);							//convert result to byte array
		
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	public static void Sub (byte [] destination, byte [] source)
	{
		int temp1;
		int temp2;
		int temp3; 											//temporary storage
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffers to convert int to byte array
		ByteBuffer intBuff1 = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		ByteBuffer intBuff2 = ByteBuffer.wrap(source);
		temp1 = intBuff1.getInt();							//convert byte array to int
		temp2 = intBuff2.getInt();							//convert string to int
		temp3 = temp1 - temp2;								//add ints
		arrayBuff.putInt(temp3);							//convert result to byte array
		
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//bitwise AND for register and value
	public static void And (byte [] destination, String source)
	{
		int reg;
		int operand;
		int temp;
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		reg = intBuff.getInt();								//convert destination to int
		operand = Integer.parseInt(source);					//convert operand to int
		temp = reg & operand;								//bitwise AND on the parameters
		arrayBuff.putInt(temp);								//convert back to integer
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//bitwise AND for two registers
	public static void And (byte [] destination, byte [] source)
	{
		int reg;
		int operand;
		int temp;
		ByteBuffer arrayBuff1 = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff1 = ByteBuffer.wrap(destination);	//byte buffers to convert byte arrays to ints
		ByteBuffer intBuff2 = ByteBuffer.wrap(source);
		reg = intBuff1.getInt();								//convert destination to int
		operand = intBuff2.getInt();
		temp = reg & operand;								//bitwise AND on the parameters
		arrayBuff1.putInt(temp);								//convert back to integer
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff1.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff1.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff1.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff1.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//bitwise OR for register and value
	public static void Or (byte [] destination, String source)
	{
		int reg;
		int operand;
		int temp;
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff = ByteBuffer.wrap(destination);	//byte buffer to convert byte array to int
		reg = intBuff.getInt();								//convert destination to int
		operand = Integer.parseInt(source);					//convert operand to int
		temp = reg | operand;								//bitwise OR on the parameters
		arrayBuff.putInt(temp);								//convert back to integer
		if(destination.equals(Memory.eax))					//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//bitwise OR for two registers
	public static void Or (byte [] destination, byte [] source)
	{
		int reg;
		int operand;
		int temp;
		ByteBuffer arrayBuff1 = ByteBuffer.allocate(4);			//byte buffer to convert int to byte array
		ByteBuffer intBuff1 = ByteBuffer.wrap(destination);		//byte buffers to convert byte arrays to ints
		ByteBuffer intBuff2 = ByteBuffer.wrap(source);
		reg = intBuff1.getInt();								//convert destination to int
		operand = intBuff2.getInt();
		temp = reg | operand;									//bitwise OR on the parameters
		arrayBuff1.putInt(temp);								//convert back to integer
		if(destination.equals(Memory.eax))						//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff1.array());
		}
		else if (destination.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff1.array());
		}
		else if (destination.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff1.array());
		}
		else if (destination.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff1.array());
		}
		else
			System.out.println("Something went wrong.");
	}
	
	//bitwise NOT on one register
	public static void Not (byte [] register)
	{
		int temp1;
		int temp2;
		ByteBuffer arrayBuff = ByteBuffer.allocate(4);		//byte buffer to convert int to byte array
		ByteBuffer intBuff = ByteBuffer.wrap(register);		//byte buffer to convert byte arrays to ints
		temp1 = intBuff.getInt();							//convert register to int
		temp2 = ~temp1;										//bitwise NOT
		arrayBuff.putInt(temp2);							//convert back to array
		if(register.equals(Memory.eax))						//write to memory
		{
			Memory.copy(Memory.eax, arrayBuff.array());
		}
		else if (register.equals(Memory.ebx))
		{
			Memory.copy(Memory.ebx, arrayBuff.array());
		}
		else if (register.equals(Memory.ecx))
		{
			Memory.copy(Memory.ecx, arrayBuff.array());
		}
		else if (register.equals(Memory.edx))
		{
			Memory.copy(Memory.edx, arrayBuff.array());
		}
		else
			System.out.println("Something went wrong.");
		
	}
	
	
	//method to parse string of hex values into human-readable characters
	public static String hexToChar(String hexStr)
	{
		String charStr = "";
		String hexSubStr = "";
		int temp;
		
		//loop through input string
		for (int i = 0; i < hexStr.length()-1; i += 2)
		{
			//get hex pairs
			hexSubStr = hexStr.substring(i, (i+2));
			
			//convert hex to decimal
			temp = Integer.parseInt(hexSubStr);
			
			//convert decimal to char
			charStr += (char)temp;
		}
		
		return charStr;
	}

}
