//Person Class
//Coded by David Small on 2 July 2014
//Updated to have expection handling on 2 August 2014

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project_5
{
    [Serializable]
    public class PhoneNumberException : Exception
    {
        public PhoneNumberException() { }
        public PhoneNumberException(string message) : base(message) { }
        public PhoneNumberException(string message, Exception inner) : base(message, inner) { }
        protected PhoneNumberException(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }

    class Person
    {
        private string firstName = "";

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        private string lastName = "";

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        private string phoneNumber = "";

        public string PhoneNumber
        {
            get { return phoneNumber; }
            set 
            { 
                if (value.Length == 10)
                    phoneNumber = value; 
                else
                    throw new PhoneNumberException();
            }
        }

        private Address address = new Address();

        public Address Address
        {
            get { return address; }
            set { address = value; }
        }

        public Person()
        {
            this.firstName = "Dee";
            this.lastName = "Fault";
            this.phoneNumber = "0000000000";
        }

        public Person(string initFirstName, string initLastName, string initPhone)
        {
            string userInput = "";

            this.firstName = initFirstName;
            this.lastName = initLastName;
            this.phoneNumber = initPhone;

            Console.Write("Please enter this person's street address\nexcluding any apartment numbers:\n");
            userInput = Console.ReadLine();
            this.address.StreetAddress = userInput;

            Console.Write("Does this person's address have an apartnemt number (y/n)?  ");
            userInput = Console.ReadLine();

            if (userInput[0] == 'y' || userInput[0] == 'Y')
            {
                Console.Write("Please enter it here:  ");
                userInput = Console.ReadLine();
                this.address.ApartmentNumber = userInput;
            }

            Console.Write("Please enter this person's city of residence:  ");
            userInput = Console.ReadLine();
            this.address.City = userInput;

            Console.Write("Please enter this person's state of residence:  ");
            userInput = Console.ReadLine();
            this.address.State = userInput;

            Console.Write("Please enter this person's zip code:  ");
            userInput = Console.ReadLine();
            this.address.ZipCode = userInput;
        }

        public override string ToString()
        {
            return string.Format("\nName: {0} {1}\nPhone: {2}\nAddress: {3}", this.FirstName, this.LastName, this.PhoneNumber, this.address);

        }
    }
}
