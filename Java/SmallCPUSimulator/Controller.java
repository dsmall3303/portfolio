//main class for CPU simulator project
//coded by David Small on 26 April 2016 with the assistance of a lot of caffiene and vaporwave

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

import main.Memory;
import main.ALUEmulator;

public class Controller 
{
	private static String menuOption = "";
	private static String command = "";
	private static String op1 = "";
	private static String op2 = "";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int tempInt;
	private static int tempInt2;
	private static ByteBuffer arrayBuff = ByteBuffer.allocate(4);
	private static ByteBuffer intBuff;
	private static ByteBuffer intBuff2;
	
	public static void main(String[] args) throws IOException
	{
		Memory.resetRegister(Memory.eax);	//set all registers to 0
		Memory.resetRegister(Memory.ebx);
		Memory.resetRegister(Memory.ecx);
		Memory.resetRegister(Memory.edx);
		
		while(menuOption != "q")					//main command loop
		{
			arrayBuff.clear();
			
			System.out.println("Choose a command:");
			System.out.println("1) Enter Command");
			System.out.println("2) Display registers");
			System.out.println("3) Quit");
			System.out.print(">");
			try 
			{
				menuOption = br.readLine();		//get input
				switch(menuOption)
				{
				case "1":
					System.out.println("Please use only lowercase!");		
					System.out.print(">");
					command = br.readLine();							//get command
					if(command.substring(0,2).equals("or"))				//OR requires special handling due to its length
					{
						op1 = command.substring(3,6);					//get destination
						op2 = command.substring(7, command.length());	//get source
						switch (op1)			//decide which register to use
						{
						case "eax":				//eax
							switch (op2)		//check if comparing against another register or a raw value
							{
							case "eax":			//execute proper method
								//OR against itself has no effect
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "ebx":
								ALUEmulator.Or(Memory.eax, Memory.ebx);
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "ecx":
								ALUEmulator.Or(Memory.eax, Memory.ecx);
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "edx":
								ALUEmulator.Or(Memory.eax, Memory.edx);
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							default:		//if not ORing against a register, then use raw value
								ALUEmulator.Or(Memory.eax, op2);
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							}
							break;
						case "ebx":			//ebx
							switch (op2)	//check if comparing against another register or a raw value
							{
							case "eax":		//execute proper method
								ALUEmulator.Or(Memory.ebx, Memory.eax);
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "ebx":
								//OR against itself has no effect
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "ecx":
								ALUEmulator.Or(Memory.ebx, Memory.ecx);
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "edx":
								ALUEmulator.Or(Memory.ebx, Memory.edx);
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							default:		//if not ORing against a register, then use raw value
								ALUEmulator.Or(Memory.ebx, op2);
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							}
							break;
						case "ecx":			//ecx
							switch (op2)	//check if comparing against another register or a raw value
							{
							case "eax":
								ALUEmulator.Or(Memory.ecx, Memory.eax);
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "ebx":
								ALUEmulator.Or(Memory.ecx, Memory.ebx);
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "ecx":
								//OR against itself has no effect
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "edx":
								ALUEmulator.Or(Memory.ecx, Memory.edx);
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							default:		//if not ORing against a register, then use raw value
								ALUEmulator.Or(Memory.ecx, op2);
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							}
							break;
						case "edx":			//edx
							switch (op2)	//check if comparing against another register or a raw value
							{
							case "eax":
								ALUEmulator.Or(Memory.edx, Memory.eax);
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							case "ebx":
								ALUEmulator.Or(Memory.edx, Memory.ebx);
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							case "ecx":
								ALUEmulator.Or(Memory.edx, Memory.ecx);
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							case "edx":
								//OR against itself has no effect
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							default:		//if not ORing against a register, then use raw value
								ALUEmulator.Or(Memory.edx, op2);
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							}
							break;
						}
						break;
					}
					
					else if (command.substring(0,3).equals("not") || command.substring(0,3).equals("inc") || command.substring(0,3).equals("dec"))		
						//NOT, INC, and DEC require special handling because they only take one operand
					{
						op1 = command.substring(4, command.length());	//get operand
						switch(command.substring(0,3))
						{
						case "not":
							switch (op1)		//pick a register, any register
							{
							case "eax":
								ALUEmulator.Not(Memory.eax);
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "ebx":
								ALUEmulator.Not(Memory.ebx);
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "ecx":
								ALUEmulator.Not(Memory.ecx);
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "edx":
								ALUEmulator.Not(Memory.edx);
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							default:
								break;
							}
							break;
						case "inc":
							switch(op1)		//pick a register, any register
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.eax);		
								tempInt = intBuff.getInt();					//convert byte array to int
								tempInt++;									//increment
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());	//convert int back to array
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt++;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt++;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt++;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							}
							break;
						case "dec":
							switch(op1)	//pick a register, any register
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.eax);		
								tempInt = intBuff.getInt();					//convert array to int
								tempInt--;									//decrement
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());	//convert int back to array
								System.out.println(Memory.getBitString(Memory.eax));
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt--;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.ebx));
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt--;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.ecx));
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt--;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								System.out.println(Memory.getBitString(Memory.edx));
								break;
							}
							break;
						}
					}
					else if (command.substring(0,4).equals("idiv")||command.substring(0,4).equals("imul"))
					{
						op1 = command.substring(5,8);
						op2 = command.substring(9, command.length());
						switch(command.substring(0,4))
						{
						case "imul":	//signed multiplication
						switch(op1)		//switch on destination
						{
						case "eax":
							switch(op2)	//switch on source
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.eax);		
								tempInt = intBuff.getInt();					//convert array to int
								tempInt *= tempInt;							//multiply by itself
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());	//convert int back to array
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);	
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();				//convert arrays to ints
								tempInt *= tempInt2;						//multiply
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());	//write to memory
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							}
							break;
						case "ebx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt *= tempInt;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							}
							break;
						case "ecx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt *= tempInt;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							}
							break;
						case "edx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt *= tempInt;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt *= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							}
							break;
						default:
							System.out.println("Something went wrong.");
							break;
						}
						break;
					case "idiv":	//signed division
//						if(Integer.parseInt(op2) == 0)	//sanity check
//						{
//							break;
//						}
						switch(op1)		//switch on destination
						{
						case "eax":
							switch(op2)	//switch on source
							{
							case "eax":	//division by self equals 1
								tempInt = 1;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.eax);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							}
							break;
						case "ebx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "ebx":
								tempInt = 1;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.ebx);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ebx, arrayBuff.array());
								break;
							}
							break;
						case "ecx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							case "ecx":
								tempInt = 1;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							case "edx":
								intBuff = ByteBuffer.wrap(Memory.ecx);
								intBuff2 = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.ecx, arrayBuff.array());
								break;
							}
							break;
						case "edx":
							switch(op2)
							{
							case "eax":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.eax);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "ebx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.ebx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "ecx":
								intBuff = ByteBuffer.wrap(Memory.edx);
								intBuff2 = ByteBuffer.wrap(Memory.ecx);
								tempInt = intBuff.getInt();
								tempInt2 = intBuff2.getInt();
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							case "edx":
								tempInt = 1;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.eax, arrayBuff.array());
								break;
							default:
								intBuff = ByteBuffer.wrap(Memory.edx);
								tempInt = intBuff.getInt();
								tempInt2 = Integer.parseInt(op2);
								tempInt /= tempInt2;
								arrayBuff.putInt(tempInt);
								Memory.copy(Memory.edx, arrayBuff.array());
								break;
							}
							break;
						default:
							System.out.println("Something went wrong.");
							break;
						}
						break;
						}
					}
					else 
					{
						op1 = command.substring(4,7);					//get destination
						op2 = command.substring(8, command.length());	//get source
						
						switch(command.substring(0, 4))		//see which command to run
						{
						case "add ":		//addition
							switch (op1)	//decide which register to use
							{
							case "eax":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Add(Memory.eax, Memory.eax);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ebx":
									ALUEmulator.Add(Memory.eax, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ecx":
									ALUEmulator.Add(Memory.eax, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "edx":
									ALUEmulator.Add(Memory.eax, Memory.edx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								default:
									ALUEmulator.Add(Memory.eax, op2);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								}
								break;
							case "ebx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Add(Memory.ebx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ebx":
									ALUEmulator.Add(Memory.ebx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ecx":
									ALUEmulator.Add(Memory.ebx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "edx":
									ALUEmulator.Add(Memory.ebx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								default:
									ALUEmulator.Add(Memory.ebx, op2);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								}
								break;
							case "ecx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Add(Memory.ecx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ebx":
									ALUEmulator.Add(Memory.ecx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ecx":
									ALUEmulator.Add(Memory.ecx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "edx":
									ALUEmulator.Add(Memory.ecx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								default:
									ALUEmulator.Add(Memory.ecx, op2);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								}
								break;
							case "edx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Add(Memory.edx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ebx":
									ALUEmulator.Add(Memory.edx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ecx":
									ALUEmulator.Add(Memory.edx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "edx":
									ALUEmulator.Add(Memory.edx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								default:
									ALUEmulator.Add(Memory.edx, op2);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								}
								break;
							}
							break;
						case "sub ":		//subtraction
							switch (op1)	//decide which register to use
							{
							case "eax":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Sub(Memory.eax, Memory.eax);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ebx":
									ALUEmulator.Sub(Memory.eax, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ecx":
									ALUEmulator.Sub(Memory.eax, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "edx":
									ALUEmulator.Sub(Memory.eax, Memory.edx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								default:
									ALUEmulator.Sub(Memory.eax, op2);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								}
								break;
							case "ebx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Sub(Memory.ebx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ebx":
									ALUEmulator.Sub(Memory.ebx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ecx":
									ALUEmulator.Sub(Memory.ebx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "edx":
									ALUEmulator.Sub(Memory.ebx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								default:
									ALUEmulator.Sub(Memory.ebx, op2);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								}
								break;
							case "ecx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Sub(Memory.ecx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ebx":
									ALUEmulator.Sub(Memory.ecx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ecx":
									ALUEmulator.Sub(Memory.ecx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "edx":
									ALUEmulator.Sub(Memory.ecx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								default:
									ALUEmulator.Sub(Memory.ecx, op2);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								}
								break;
							case "edx":
								switch (op2)	//check if adding from other register or raw value
								{
								case "eax":
									ALUEmulator.Sub(Memory.edx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ebx":
									ALUEmulator.Sub(Memory.edx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ecx":
									ALUEmulator.Sub(Memory.edx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "edx":
									ALUEmulator.Sub(Memory.edx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								default:
									ALUEmulator.Sub(Memory.edx, op2);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								}
								break;
							}
							break;
						case "and ":		//bitwise AND
							switch (op1)	//decide which register to use as destination
							{
							case "eax":
								switch (op2)	//check if ANDing from other register or raw value
								{
								case "eax":
									ALUEmulator.And(Memory.eax, Memory.eax);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ebx":
									ALUEmulator.And(Memory.eax, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ecx":
									ALUEmulator.And(Memory.eax, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "edx":
									ALUEmulator.And(Memory.eax, Memory.edx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								default:
									ALUEmulator.And(Memory.eax, op2);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								}
								break;
							case "ebx":
								switch (op2)	//check if ANDing from other register or raw value
								{
								case "eax":
									ALUEmulator.And(Memory.ebx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ebx":
									ALUEmulator.And(Memory.ebx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ecx":
									ALUEmulator.And(Memory.ebx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "edx":
									ALUEmulator.And(Memory.ebx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								default:
									ALUEmulator.And(Memory.ebx, op2);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								}
								break;
							case "ecx":
								switch (op2)	//check if ANDing from other register or raw value
								{
								case "eax":
									ALUEmulator.And(Memory.ecx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ebx":
									ALUEmulator.And(Memory.ecx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ecx":
									ALUEmulator.And(Memory.ecx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "edx":
									ALUEmulator.And(Memory.ecx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								default:
									ALUEmulator.And(Memory.ecx, op2);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								}
								break;
							case "edx":
								switch (op2)	//check if ANDing from other register or raw value
								{
								case "eax":
									ALUEmulator.And(Memory.edx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ebx":
									ALUEmulator.And(Memory.edx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ecx":
									ALUEmulator.And(Memory.edx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "edx":
									ALUEmulator.And(Memory.edx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								default:
									ALUEmulator.And(Memory.edx, op2);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								}
								break;
							}
							break;
						
						case "mul ":			//unsigned multiplication
							switch(op1)		//switch on destination
							{
							case "eax":
								switch(op2)	//switch on source
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.eax);		
									tempInt = Math.abs(intBuff.getInt());					//convert array to int
									tempInt *= tempInt;										//multiply by itself
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());				//convert int back to array
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);	
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());				//convert arrays to ints
									tempInt *= tempInt2;								//multiply
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());			//write to memory
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								}
								break;
							case "ebx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());	
									tempInt *= tempInt;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.ebx);
									tempInt = intBuff.getInt();
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								}
								break;
							case "ecx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									tempInt = intBuff.getInt();
									tempInt = Math.abs(intBuff.getInt());	
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								}
								break;
							case "edx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());	
									tempInt *= tempInt;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt *= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								}
								break;
							default:
								System.out.println("Something went wrong.");
								break;
							}
							break;
						case "div ":		//unsigned division
//							if(Integer.parseInt(op2) == 0)
//							{
//								break;	//sanity check
//							}
							switch(op1)			//switch on destination
							{
							case "eax":
								switch(op2)		//switch on source
								{
								case "eax":
									tempInt = 1;								//division by self equals 1
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());	//convert int back to array
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);	
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());				//convert arrays to ints
									tempInt /= tempInt2;								//divide
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());			//write to memory
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.eax);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									break;
								}
								break;
							case "ebx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "ebx":
									tempInt = 1;								//division by self equals 1
									arrayBuff.putInt(tempInt);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.ebx);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									break;
								}
								break;
							case "ecx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "ecx":
									tempInt = 1;								//division by self equals 1
									arrayBuff.putInt(tempInt);	
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								case "edx":
									intBuff = ByteBuffer.wrap(Memory.ecx);
									intBuff2 = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									break;
								}
								break;
							case "edx":
								switch(op2)
								{
								case "eax":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.eax);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "ebx":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.ebx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "ecx":
									intBuff = ByteBuffer.wrap(Memory.edx);
									intBuff2 = ByteBuffer.wrap(Memory.ecx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(intBuff2.getInt());
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								case "edx":
									tempInt = 1;								//division by self equals 1
									arrayBuff.putInt(tempInt);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								default:
									intBuff = ByteBuffer.wrap(Memory.edx);
									tempInt = Math.abs(intBuff.getInt());
									tempInt2 = Math.abs(Integer.parseInt(op2));
									tempInt /= tempInt2;
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									break;
								}
								break;
							default:
								System.out.println("Something went wrong.");
								break;
							}
							break;
						case "mov ":	//copy values to registers
							switch (op1)//decide which register to copy to
							{
							case "eax":
								switch (op2)//check if copying from other register or from raw value
								{
								case "eax":
									Memory.copy(Memory.eax, Memory.eax);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ebx":
									Memory.copy(Memory.eax, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ecx":
									Memory.copy(Memory.eax, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "edx":
									Memory.copy(Memory.eax, Memory.edx);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								default:
									tempInt = Integer.parseInt(op2);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.eax, arrayBuff.array());
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								}
								break;
							case "ebx":
								switch (op2)//check if copying from other register or from raw value
								{
								case "eax":
									Memory.copy(Memory.ebx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ebx":
									Memory.copy(Memory.ebx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ecx":
									Memory.copy(Memory.ebx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "edx":
									Memory.copy(Memory.ebx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								default:
									tempInt = Integer.parseInt(op2);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ebx, arrayBuff.array());
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								}
								break;
							case "ecx":
								switch (op2)//check if copying from other register or from raw value
								{
								case "eax":
									Memory.copy(Memory.ecx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ebx":
									Memory.copy(Memory.ecx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ecx":
									Memory.copy(Memory.ecx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "edx":
									Memory.copy(Memory.ecx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								default:
									tempInt = Integer.parseInt(op2);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.ecx, arrayBuff.array());
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								}
								break;
							case "edx":
								switch (op2)//check if copying from other register or from raw value
								{
								case "eax":
									Memory.copy(Memory.edx, Memory.eax);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ebx":
									Memory.copy(Memory.edx, Memory.ebx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ecx":
									Memory.copy(Memory.edx, Memory.ecx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "edx":
									Memory.copy(Memory.edx, Memory.edx);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								default:
									tempInt = Integer.parseInt(op2);
									arrayBuff.putInt(tempInt);
									Memory.copy(Memory.edx, arrayBuff.array());
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								}
								break;
							default:
								break;
							}
							break;
						case "xchg":					//exchange
							byte [] temp = new byte [4];//temporary holder for swapping values
							switch (op1)	//determine destination
							{
							case "eax":
								switch (op2)//determine source
								{
								case "eax":
									//no swapping a register with itself
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ebx":
									Memory.copy(temp, Memory.eax);
									Memory.copy(Memory.eax, Memory.ebx);
									Memory.copy(Memory.ebx, temp);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "ecx":
									Memory.copy(temp, Memory.eax);
									Memory.copy(Memory.eax, Memory.ecx);
									Memory.copy(Memory.ecx, temp);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								case "edx":
									Memory.copy(temp, Memory.eax);
									Memory.copy(Memory.eax, Memory.edx);
									Memory.copy(Memory.edx, temp);
									System.out.println(Memory.getBitString(Memory.eax));
									break;
								default:
									System.out.println("Something went wrong.");
								}
								break;
							case "ebx":
								switch (op2)//determine source
								{
								case "eax":
									Memory.copy(temp, Memory.ebx);
									Memory.copy(Memory.ebx, Memory.eax);
									Memory.copy(Memory.eax, temp);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ebx":
									//no swapping a register with itself
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "ecx":
									Memory.copy(temp, Memory.ebx);
									Memory.copy(Memory.ebx, Memory.ecx);
									Memory.copy(Memory.ecx, temp);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								case "edx":
									Memory.copy(temp, Memory.ebx);
									Memory.copy(Memory.ebx, Memory.edx);
									Memory.copy(Memory.edx, temp);
									System.out.println(Memory.getBitString(Memory.ebx));
									break;
								default:
									System.out.println("Something went wrong.");
								}
								break;
							case "ecx":
								switch (op2)//determine source
								{
								case "eax":
									Memory.copy(temp, Memory.ecx);
									Memory.copy(Memory.ecx, Memory.eax);
									Memory.copy(Memory.eax, temp);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ebx":
									Memory.copy(temp, Memory.ecx);
									Memory.copy(Memory.ecx, Memory.ebx);
									Memory.copy(Memory.ebx, temp);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "ecx":
									//no swapping a register with itself
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								case "edx":
									Memory.copy(temp, Memory.ecx);
									Memory.copy(Memory.ecx, Memory.edx);
									Memory.copy(Memory.edx, temp);
									System.out.println(Memory.getBitString(Memory.ecx));
									break;
								default:
									System.out.println("Something went wrong.");
								}
								break;
							case "edx":
								switch (op2)//determine source
								{
								case "eax":
									Memory.copy(temp, Memory.edx);
									Memory.copy(Memory.edx, Memory.eax);
									Memory.copy(Memory.eax, temp);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ebx":
									Memory.copy(temp, Memory.edx);
									Memory.copy(Memory.edx, Memory.ebx);
									Memory.copy(Memory.ebx, temp);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "ecx":
									Memory.copy(temp, Memory.edx);
									Memory.copy(Memory.edx, Memory.ecx);
									Memory.copy(Memory.ecx, temp);
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								case "edx":
									//no swapping a register with itself
									System.out.println(Memory.getBitString(Memory.edx));
									break;
								default:
									System.out.println("Something went wrong.");
								}
								break;
							}
							break;
						case "push":
							System.out.println("Not yet implemented ):");
							break;
						case "pop ":
							System.out.println("Not yet implemented ):");
							break;
						default:
							System.out.println("Something went wrong D:");
						}
					}
					
					break;
				case "2":
					System.out.println("eax: " + Memory.getBitString(Memory.eax));
					System.out.println("ebx: " + Memory.getBitString(Memory.ebx));
					System.out.println("ecx: " + Memory.getBitString(Memory.ecx));
					System.out.println("edx: " + Memory.getBitString(Memory.edx));
					break;
				case "3":
					menuOption = "q";
					break;
				default:
					System.out.println("Please choose a valid menu option!");
					break;
				}
				//System.out.println("Press ENTER to continue...");
				//br.readLine();
			}
			
			finally
			{}
		}
//		System.out.println("I t ' s  a l l  i n  y o u r  h e a d");
//		try 
//		{
//			br.readLine();
//		} 
//		
//		
//		catch (IOException e) 
//		{
//			System.out.println("Something has gone terribly wrong!");
//			e.printStackTrace();
//		}
	}

}


/*
 * Commands to handle:
 * ADD
 * SUB
 * MUL
 * DIV
 * IMUL
 * IDIV
 * INC
 * DEC
 * MOV
 * XCHG
 * PUSH
 * POP
 * 
 * Flag register
 * 
 * JMP
 */
