using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DecisionTest
{
    class Program
    {
        static void Main(string[] args)
        {
            string again = "";
            int sum = 0;

            again = "y";

            Console.Write("Would you like to enter another value (y/n)?   ");
            again = Console.ReadLine();

            while (again == "y" || again == "Y")
            {
                Console.WriteLine("Please enter an int: ");
                string userInput = Console.ReadLine();
                int number = int.Parse(userInput);

                sum += number;

                Console.WriteLine("Would you like to enter another value (y/n)?   ");
                again = Console.ReadLine();
            }

            /*age = int.Parse(userInput);

            if (age < 5 && age >= 0)
            {
                Console.WriteLine("Brat!");
            }
            else if (age > 55)
            {
                Console.WriteLine("Bones!");
            }
            else
            {
                Console.WriteLine("Beautigul!");
            }
            */


            /*
             * if(int.TryParse(userInput, out age))
             * {
             *  if(thing)
             *  {
             *      doThing();
             *  }
             *  else
             *  {
             *      doOtherThing();
             *   }
             *  }
             *  else
             *  {
             *      Console.WriteLine("{0} is not an int!", userInput);
             *  }
             */
        }
    }
}
