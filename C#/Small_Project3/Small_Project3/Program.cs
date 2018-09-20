//Division tutor program
//programmed by David Small on 22 June 2014
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project3
{
    class Program
    {
        public static int correctAnswer = 0;

        static void Main(string[] args)
        {
            char isDone = 'n';

            int dividend = 0;
            int divisor = 1;
            int MIN_VAL = 0;
            int MAX_VAL = 12;
            int userInt = 0;

            string userInput = "";

            Random rnd = new Random();

            Console.WriteLine("////-----------------------------------\\\\\\\\");
            Console.WriteLine("|          Division Tutor v.0.0.1         |");
            Console.WriteLine("\\\\\\\\-----------------------------------////");

            do
            {
                do
                {
                    GenNewDividend(ref dividend, MIN_VAL, MAX_VAL, rnd);
                    GenNewDivisor(ref divisor, MIN_VAL+1, MAX_VAL, rnd);
                } while ((dividend % divisor) != 0);

                correctAnswer = dividend / divisor;
                
                DisplayProblem(dividend, divisor);

                userInput = Console.ReadLine();
                userInt = int.Parse(userInput);

                if (userInt == correctAnswer)
                {
                    Console.WriteLine("Correct!");
                }
                else
                {
                    Console.WriteLine("Wrong!");
                }

                isDone = GetGoAgain();

            }while(isDone != 'n' && isDone != 'N');
            
            Console.WriteLine("Thanks for using this program!");
        }

        private static int GenInt(int min, int max, Random rnd)
        {
            return rnd.Next(min, max + 1);
        }


        private static char GetGoAgain()
        {
            Console.WriteLine("Would you like to try another problem?");
            string tempString = Console.ReadLine();
            char temp = tempString[0];
            return temp;

        }

        private static void DisplayProblem(int dividend, int divisor)
        {
            Console.WriteLine("What is {0} divided by {1}?", dividend, divisor);
            Console.WriteLine(">");
        }

        private static void GenNewDivisor(ref int divisor, int min, int max, Random rnd)
        {
            divisor = GenInt(min, max, rnd);
        }

        private static void GenNewDividend(ref int dividend, int min, int max, Random rnd)
        {
            dividend = GenInt(min, max, rnd);
        }

    }


}
