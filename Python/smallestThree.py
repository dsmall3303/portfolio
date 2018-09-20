number1=0
number2=0
number3=0

user_input=''

smallest=0

#INPUT
#get three numbers from the user
user_input=input("Please enter the first number: ")
number1=int(user_input)

user_input=input("Please enter the second number: ")
number2=int(user_input)

user_input=input("Please enter the third number: ")
number3=int(user_input)

#PROCESSING
#determine the smallest number
smallest = number1

if number2 < smallest:
    smallest = number2

if number3 < smallest:
    smallest = number3

#OUTPUT
#display smallest
print('The smallest is', smallest)
