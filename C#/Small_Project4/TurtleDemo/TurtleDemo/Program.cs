//TurtleLang emukator program
//Coded by David Small on 6 July 2014
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TurtleDemo
{
    class Program
    {
        //enum to represent the turtle commands

        enum TurtleCommands
        {
            PenUp       = 1,
            PenDown     = 2,
            TurnRight   = 3,
            TurnLeft    = 4,
            Move        = 5,
            Print       = 6,
            End         = 9
        };

        //enum to represent directions
        enum TurtleDirection
        {
            UP,
            DOWN,
            LEFT,
            RIGHT
        };

        static void Main(string[] args)
        {
           

            //2-dimensional array of ints to store commands
            int[,] turtleProgram = GetProgram();

            Execute(turtleProgram);
            
        }

        static void Execute(int[,] turtleProgram)
        {
            //a 20x20 array floor initialized to 0's
            int[,] floor = new int[20, 20];
            char [,] displayFloor = new char [20,20];
            ClearFloor(floor);

            //turtle properties
            bool penDown = false;
            TurtleDirection facing = TurtleDirection.RIGHT;
            int xCoord = 0;
            int yCoord = 0;

            //control variables
            int moveCounter = 0;
            int commandIndex = 0;

            TurtleCommands nextCommand = (TurtleCommands)turtleProgram[commandIndex, 0];

            while (nextCommand != TurtleCommands.End)
            {
                //execute command
                switch (nextCommand)
                {
                    case TurtleCommands.PenUp:                                      //raises the turtle's pen                                    
                        penDown = false;
                        break;
                    case TurtleCommands.PenDown:                                    //lowers the turtle's pen
                        penDown = true;
                        break;
                    case TurtleCommands.TurnRight:                                  //turns the turtle right 90 degrees
                        facing = NewDirection(facing, TurtleCommands.TurnRight);    
                        break;
                    case TurtleCommands.TurnLeft:                                   //turns the turtle left 90 degrees
                        facing = NewDirection(facing, TurtleCommands.TurnLeft);
                        break;
                    case TurtleCommands.Move:                                       //moves the turtle the indicated number of spaces    
                        switch (facing)
                        {
                            case TurtleDirection.UP:
                                moveCounter = turtleProgram[commandIndex, 1];       //get number of spaces to move. This code is repeated for each of the directions.
                                if (yCoord > 0)                                     //check to see if at edge of floor
                                {
                                    while (moveCounter > 0)                         //check for moves remaining
                                    {
                                        if (penDown)                                //check for pen down
                                        {
                                            floor[xCoord, yCoord] = 1;
                                        }
                                        if (yCoord > 0)                             //check if movement has caused turtle to reach end of floor.
                                                                                    //required due to movement near end of loop
                                        {
                                            yCoord--;
                                        }
                                        moveCounter--;

                                    }
                                    
                                }
                                break;
                            case TurtleDirection.DOWN:
                                moveCounter = turtleProgram[commandIndex, 1];
                                if (yCoord < 19)
                                {
                                    while (moveCounter > 0)
                                    {
                                        if (penDown)
                                        {
                                            floor[xCoord, yCoord] = 1;
                                        }
                                        if (yCoord < 19)
                                        {
                                            yCoord++;
                                        }
                                        moveCounter--;
                                    }
                                }
                                break;
                            case TurtleDirection.LEFT:
                                moveCounter = turtleProgram[commandIndex, 1];
                                if (xCoord > 0)
                                {
                                    while (moveCounter > 0)
                                    {
                                        if (penDown)
                                        {
                                            floor[xCoord, yCoord] = 1;
                                        }
                                        if (xCoord > 0)
                                        {
                                            xCoord--;
                                        }
                                        moveCounter--;
                                    }
                                }
                                break;
                            case TurtleDirection.RIGHT:
                                moveCounter = turtleProgram[commandIndex, 1];
                                if (xCoord < 19)
                                {
                                    while (moveCounter > 0)
                                    {
                                        if (penDown)
                                        {
                                            floor[xCoord, yCoord] = 1;
                                        }
                                        if (xCoord < 19)
                                        {
                                            xCoord++;
                                        }
                                        moveCounter--;
                                    }
                                }
                                break;
                            default:
                                Console.WriteLine("Something went wrong in Execute(move command)");
                                break;
                        }
                        break;
                    case TurtleCommands.Print:                                          //creates secondary array of characters that mirrors the floor and prints it
                        for (int x = 0; x < floor.GetUpperBound(0); x++)
                        {
                            for (int y = 0; y < floor.GetUpperBound(1); y++)
                            {
                                if (floor[x, y] == 0)
                                {
                                    displayFloor[x, y] = ' ';
                                }
                                else
                                {
                                    displayFloor[x, y] = '*';
                                }
                            }
                        }

                        for (int x = 0; x < displayFloor.GetUpperBound(0); x++)
                        {
                            for (int y = 0; y < displayFloor.GetUpperBound(1); y++)
                            {
                                if (x != 19)
                                {
                                    Console.Write(displayFloor[x, y]);
                                }
                                else
                                {
                                    Console.WriteLine(displayFloor[x, y]);
                                }
                            }
                        }

                        break;
                    case TurtleCommands.End:
                        Console.WriteLine("END OF PROGRAM");
                        break;
                    default:
                        Console.WriteLine("Something went wrong in Execute (unknown command)");
                        break;
                }
                commandIndex++;                                                     //move control variable
                nextCommand = (TurtleCommands)turtleProgram[commandIndex, 0];       //change which command is being evaluated
            }
        }

        private static TurtleDirection NewDirection(TurtleDirection facing, TurtleCommands turnCommand)
        {
            if (turnCommand == TurtleCommands.TurnRight)
            {
                switch (facing)
                {
                    case TurtleDirection.UP:
                        return TurtleDirection.RIGHT;
                    case TurtleDirection.DOWN:
                        return TurtleDirection.LEFT;
                    case TurtleDirection.LEFT:
                        return TurtleDirection.UP;
                    case TurtleDirection.RIGHT:
                        return TurtleDirection.DOWN;
                    default:
                        return facing;
                }
            }
            else
            {
                switch (facing)
                {
                    case TurtleDirection.UP:
                        return TurtleDirection.LEFT;
                    case TurtleDirection.DOWN:
                        return TurtleDirection.RIGHT;
                    case TurtleDirection.LEFT:
                        return TurtleDirection.DOWN;
                    case TurtleDirection.RIGHT:
                        return TurtleDirection.UP;
                    default:
                        return facing;
                }
            }
        }

        static int[,] GetProgram()
        {
            int[,] program = new int[100, 2];
            int commandIndex = 0;
            string command = "";
            int moveVar = 0;

            DisplayInstructions();

            do
            {
                //load array with turtle commands
                //get these commands form user

                //get turtle comands from the user
                command = GetCommand();
                if (command == "5")
                {
                    Console.WriteLine("How many spaces?");
                    Console.Write("Enter a number between 0 and 19:   ");
                    moveVar = int.Parse(Console.ReadLine());
                }

                //store commands in next available slot(s) in array
                StoreCommand(command, program, commandIndex);
                if (command == "5")
                {
                    program[commandIndex, 1] = moveVar;
                }
                commandIndex++;
            }while (command != "9");



            return program;
        }

        private static void DisplayInstructions()
        {
            Console.WriteLine("Please enter one of the following numbers for your program: ");
            Console.WriteLine("1) Raise Pen");
            Console.WriteLine("2) Lower Pen");
            Console.WriteLine("3) Turn Right");
            Console.WriteLine("4) Turn Left");
            Console.WriteLine("5) Move (will require another number)");
            Console.WriteLine("6) Print");
            Console.WriteLine("9) End");
        }

        private static void StoreCommand(string command, int[,] program, int commandIndex)
        {
            int temp = int.Parse(command);
            program[commandIndex, 0] = temp;
        }

        private static string GetCommand()
        {
            return Console.ReadLine();
        }

        static void ClearFloor(int[,] floor)
        {
            for (int x = 0; x < floor.GetUpperBound(0); x++)
            {
                for (int y = 0; y < floor.GetUpperBound(1); y++)
                {
                    floor[x, y] = 0;
                }
            }
        }

    }
}
