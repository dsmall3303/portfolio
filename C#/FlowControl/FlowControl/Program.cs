using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FlowControl
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = 0;

            int userMenuChoice = GetUserMenuChoice();

            while (count < 10)
            {
                Console.WriteLine(count);
                count++;
            }
            
            //for loop

            for (count = 0; count < 10; count++)
            {
                Console.WriteLine(count);
            }

        }

        private static int GetUserMenuChoice()
        {
            int menuChoice = 0;

            DisplayMenu();
            Console.Write("--->");
            menuChoice = int.Parse(Console.ReadLine());

            return menuChoice;
        }

        private static void DisplayMenu()
        {
            Console.WriteLine("------------------------------------");
        }
    }
}
