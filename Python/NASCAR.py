##Define a class called Car with the following attributes:
##Total Odometer Miles
##Speed in miles per hour
##Driver Name
##Sponsor
##The total odometer miles should be initialized to zero,
##and speed initialized to a random value between 1 and 120.
from random import randint

class Car():
    def __init__(self):
        self.odometer_miles = 0.0
        self.speed = randint(1,120)
        self.driver_name = ""
        self.sponsor_name = ""

##Create a list of 20 vehicles with random (or real) driver and sponsor names.
car1 = Car()
car1.driver_name = "Doctor Whooves"
car1.sponsor_name = "Gallpofreyan Motors"

car2 = Car()
car2.driver_name = "Derpy Hooves"
car2.sponsor_names = "Equestrian Optometry"

car3 = Car()
car3.driver_name = "Lyra Heartstrings"
car3.sponsor_name = "Canterlot Anthropological Society"

car4 = Car()
car4.driver_name = "Bon Bon"
car4.sponsor_name = "Manehattan Confectionary"

car5 = Car()
car5.driver_name = "Vinyl Scratch"
car5.sponsor_name = "EquiNax Records"

car6 = Car()
car6.driver_name = "Octavia"
car6.sponsor_name = "Baltimare Symphony Orchestra"

car7 = Car()
car7.driver_name = "Dinky Doo"
car7.sponsor_name = "Speedy Shipping"

car8 = Car()
car8.driver_name = "Cutie Mark Crusaders"
car8.sponsor_name = "Redheart Life Insurance"

car9 = Car()
car9.driver_name = "Princess Celestia"
car9.sponsor_name = "Equestrian Solar Power"

car10 = Car()
car10.driver_name = "Princess Luna"
car10.sponsor_name = "Equestrian Space Administration"

car11 = Car()
car11.driver_name = "Pipsqueak"
car11.sponsor_name = "Hoofington Anti-Piracy League"

car12 = Car()
car12.driver_name = "Zecora"
car12.sponsor_name = "Zebrican Coal, inc."

car13 = Car()
car13.driver_name = "Twilight Sparkle"
car13.sponsor_name = "Celestia's School for Gifted Unicorns"

car14 = Car()
car14.driver_name = "Rainbow Dash"
car14.sponsor_name = "Cloudsdale Weather Services"

car15 = Car()
car15.driver_name = "Pinkie Pie"
car15.sponsor_name = "Sugarcube Corner"

car16 = Car()
car16.driver_name = "Fluttershy"
car16.sponsor_name = "Everfree Vetinary Care"

car17 = Car()
car17.driver_name = "Rarity"
car17.sponsor_name = "Hoity Toity's Workshop"

car18 = Car()
car18.driver_name = "Applejack"
car18.sponsor_name = "Cherry Jubilee's Orchard"

car19 = Car()
car19.driver_name = "Princess Cadance"
car19.sponsor_name = "Crystal Empire Jewelry"

car20 = Car()
car20.driver_name = "Shining Armor"
car20.sponsor_name = "Equestrian Royal Guard"

car_list = [car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15, car16, car17, car18, car19, car20]

##Your main program should simulate the progress of the vehicles in the race.
##Every minute, the vehicles pick a new random speed, and their odometer miles
##are updated every minute using this equation:
####odometer_miles = odometer_miles + speed * time
##Since speed is in miles per hour, time should be in hours as well
##(1 minute is 1/60th of an hour).
##The first car to reach 500 miles should be declared the winner by printing
##the driver name and sponsor name.
##Include any useful methods in your class definition that you see fit.
not_done = True
winner = Car()
time = 0
while(not_done):
    for car in car_list:
        car.speed = randint(1,120)
        print(car.speed)
        car.odometer_miles = car.odometer_miles + (car.speed * time)
        print(car.odometer_miles)
    for car in car_list:
        if car.odometer_miles >= 500:
            not_done = False
            winner = car
    time +=1
print("And the winner is", winner.driver_name + ", sponsored by", winner.sponsor_name + "!")
