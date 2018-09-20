#1)A function that displays your name and your major at UAT.
def print_name_and_major ():
    print("Name: David Small")
    print("Major: Network Security\n")
    
#2)A function that prompts the user to enter their age and returns the user's input as an int.
def get_age():
    user_input = input("Please enter your age: ")
    output = int(user_input)
    return output

#3)A function that takes one argument -
##the argument will be a name that is a string.
##The function will display a message like the this:
##          Hello Drale Glacen!
def greet_by_name(name_string):
    print("Hello" , name_string + "!\n")

#4)A function that takes an integer argument called number and returns the inverse of that number.
def invert_number(number):
    inverse = -number
    return inverse

#5)A function that takes an integer argument called count and a string argument called message.
##The function will display the message <count> times. For example, if the message is "Hello!"
##and the count is 3, then the functions will display "Hello!" three times.
def repeat_message (count, message):
    while count > 0:
        print (message)
        count -= 1
    print("\n")

#6)A function called get_biggest that takes two int arguments called num1 and num2.
##The function will return the largest of the two argument values.
##If the arguments are equal, then it will return the first argument value.
def get_biggest(num1, num2):
    if num1 > num2:
        return num1
    elif num2 > num1:
        return num2
    else:
        return num1
        
#7)A function that takes a string argument and counts and returns the number of capital letters in the argument string.
##For example, if the argument value is "My name is Phill Miller.", then the return value will be 3.
def count_capitals(string):
    capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    capital_counter = 0
    for letter in string:
        if letter in capitals:
            capital_counter += 1
    return capital_counter

#8)A function that takes three int arguments and returns the middle value.
##for example, if the argument values are 5, 3, and 4, then the function will return 4.
##If there is no middle value then the function will return the most common value.
##For example, if the argument values are 5, 3, and 5, then the function will return 5.
def get_middle(int1, int2, int3):
    if int1 == int2:
        return int1
    if int2 == int3:
        return int2
    if int3 == int1:
        return int3
    
    if int2 > int1 and int1 > int3:
        return int1
    if int3 > int1 and int1 > int2:
        return int1
    if int1 > int2 and int2 > int3:
        return int2
    if int3 > int2 and int2 > int1:
        return int2
    if int1 > int3 and int3 > int2:
        return int3
    if int2 > int3 and int3 > int1:
        return int3
    ##There is probably a more elegant way to do this, but I am copmpletely stumped as to what it might be.
        
    
        
#9)A function that takes two string arguments and returns a string with only the characters that are in both of the argument strings.
##There should be no duplicate characters in the return value.
##For example, if the two argument values are "spaghetti" and "shipping" then the function should return "spghi"
##(or any five character string with these five characters that are common to both argument strings).
def unify_strings(string1, string2):
    my_string = ""
    for letter in string1:
        if letter in string2 and not letter in my_string and letter != " ":
            my_string += letter
    return my_string

#10)A function that calls each of the functions above in order to show that they work correctly.
def mane():
    user_age = 0
    user_name = ""
    num1 = 0
    num2 = 0
    num3 = 0
    user_message = ""
    message_count = 0
    biggest = 0
    num_capitals = 0
    middle = 0
    user_message2 = ""
    union_string = ""
    
    print_name_and_major()
    user_age = get_age()
    print ("User age is", user_age, "\n")
    user_name = str(input("Please enter your name: "))
    greet_by_name(user_name)
    num1 = int(input("Please enter a number: "))
    num1 = invert_number(num1)
    print("The inverse is:", num1, "\n")
    user_message = str(input("Please enter a message: "))
    message_count = int(input("How many times should I repeat that? "))
    repeat_message(message_count, user_message)
    num1 = int(input("Please enter a number: "))
    num2 = int(input("Please enter another number: "))
    biggest = get_biggest(num1, num2)
    print("The larger of the two is", biggest, "\n")
    user_message = str(input("Please enter a message: "))
    num_capitals = count_capitals(user_message)
    print("There are", num_capitals, "capital letters in that message.\n")
    num1 = int(input("Please enter a number: "))
    num2 = int(input("Please enter a second number: "))
    num3 = int(input("Please enter a third number: "))
    middle = get_middle(num1, num2, num3)
    print("The middle number is", middle,"\n")
    user_message = str(input("Please enter a message: "))
    user_message2 = str(input("Please enter another message: "))
    union_message = unify_strings(user_message, user_message2)
    print("Those messages have the following letters in common:\n"+ union_message, "\n")
