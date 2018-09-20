from random import randint

#create and use a function that takes two int factors as arguments
#and displays a multiplication problem with these factors for the user
def display_multiplication_problem(factor1, factor2):
    print("What is", factor1, "*", factor2, "?")

user_input=""
num_problems=0
factor1 = 0
factor2 = 0
money = 0
users_answer = 0
correct_answer = 0
total_attempts = 0
total_questions = 0

#asks the user how many problems they want to solve.
#If the input is less than one or more than 10, then ask again.

while num_problems < 1 or num_problems > 10:
    user_input=input("How many problems do you want to solve?\nPlease enter a number between 1 and 10. ")
    num_problems=int(user_input)
    total_questions = num_problems

while num_problems > 0:
    money+=1 #becuase mo' money mo' problems
    #generates a random multiplication problem with two random factors between 0 and 12
    factor1 = randint(0,12)
    factor2 = randint(0,12)
    correct_answer = factor1*factor2
    users_answer = -42

    #display a problem for the user
    display_multiplication_problem(factor1, factor2)

    while users_answer != correct_answer:
        #asks the user for the answer to the current problem.
        #If the answer is not correct, give a hint by telling the
        #user if the answer is too high or too low and displey the problem again.
        #If the answer is correct, display a message saying so and display the next problem.
        user_input=input("==>")
        users_answer = int(user_input)
        if (users_answer < correct_answer):
            print("Too low. Try again.")
            total_attempts += 1
        if (users_answer > correct_answer):
            print("Too high. Try again.")
            total_attempts +=1
        if (users_answer == correct_answer):
            print("Correct! Nice job!")
            total_attempts +=1
            num_problems -=1
#display the average number of trys it took to get the correct answer
average_trys = total_attempts/total_questions
print("It took an average of", average_trys, "trys to solve a problem.")
