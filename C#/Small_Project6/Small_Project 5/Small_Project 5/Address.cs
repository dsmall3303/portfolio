//Address class
//Coded by David Small on 20 July 2014
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Small_Project_5
{
    class Address
    {
        //data members and accessor/mutators
        private string streetAddress = "";

        public string StreetAddress
        {
            get { return streetAddress; }
            set { streetAddress = value; }
        }
        private string apartmentNumber = "";

        public string ApartmentNumber
        {
            get { return apartmentNumber; }
            set { apartmentNumber = value; }
        }
        private string city = "";

        public string City
        {
            get { return city; }
            set { city = value; }
        }
        private string state = "";

        public string State
        {
            get { return state; }
            set { state = value; }
        }
        private string zipCode = "";

        public string ZipCode
        {
            get { return zipCode; }
            set { zipCode = value; }
        }

        public Address()    //Defaults made obviously fake to aid in error-checking
        {
            this.streetAddress = "0 NONESUCH Lane";
            this.apartmentNumber = "0";
            this.city = "Nonesuch";
            this.state = "Nonesuch";
            this.zipCode = "Nonesuch";
        }

        public Address(string initAddress, string initCity, string initState, string initZip, string initApt = "0") //default apartment number to 0 if none provided
        {
            this.streetAddress = initAddress;
            this.city = initCity;
            this.state = initState;
            this.zipCode = initZip;
            this.apartmentNumber = initApt;
        }

        public override string ToString()   //Two different outputs based on existence of apartment number
        {
            if (this.ApartmentNumber == "0")
            {
                return string.Format("{0}, {1}, {2} {3}", this.StreetAddress, this.City, this.State, this.ZipCode);
            }
            else
            {
                return string.Format("{0}, Apartment {1}, {2}, {3} {4}", this.StreetAddress, this.ApartmentNumber, this.City, this.State, this.ZipCode);
            }
        }
    }
}
