first_number = 0
second_number = 0
user_unput = ''
largest = 0


#get the first number from the user
user_input = input("Please enter the first number: ")
first_number = int(user_input)

#get the second number from the user
user_input = input("Please enter the second number: ")
second_number = int(user_input)

#determine the largest of the two
if first_number > second_number:
    largest = first_number
else:
    largest = second_number

#display largest
print("The largest is", largest)
