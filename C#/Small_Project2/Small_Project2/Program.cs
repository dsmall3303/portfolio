//Decimal to Hexadecimal converter
//Coded by David Small on 6 June 2014

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project2
{
    class Program
    {
        static void Main(string[] args)
        {
            string notDone = "x";
            int userNumber = 0;
            string hexNumber = "";


            do
            {
                //get number from user
                userNumber = GetNumber();

                //convert number to hex
                hexNumber = ConvertToHex(userNumber);

                //display result
                Console.WriteLine("{0} is {1} in hex.", userNumber, hexNumber);

                Console.Write("Press ENTER to convert another number or press 'q' to QUIT.");
                notDone = Console.ReadLine();
            } while (notDone != "q");
        }

        //Method to get number from the user
        private static int GetNumber()
        {
            int temp = 0;
            Console.Write("Please enter a whole number between 0 and 1,000,000:   ");
            string userInput = Console.ReadLine();
            temp = int.Parse(userInput);
            return temp;
        }

        //Method to convert decimal to hexidecimal
        private static string ConvertToHex(int userNumber)
        {
            string hexNumber = "";

            int result = 0;

            while (userNumber > 0)
            {
                result = userNumber % 16;
                userNumber = userNumber/16;
                switch (result.ToString())
                {
                    case "10":
                        hexNumber = "A" + hexNumber;
                        break;
                    case "11":
                        hexNumber = "B" + hexNumber;
                        break;
                    case "12":
                        hexNumber = "C" + hexNumber;
                        break;
                    case "13":
                        hexNumber = "D" + hexNumber;
                        break;
                    case "14":
                        hexNumber = "E" + hexNumber;
                        break;
                    case "15":
                        hexNumber = "F" + hexNumber;
                        break;
                    default:
                        hexNumber = result.ToString() + hexNumber;
                        break;
                }
            }
            return hexNumber;
        }
    }
}
