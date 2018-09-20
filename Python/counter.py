count = 0
total = 0
average = 0
user_input = ""
while (user_input != "q"):
    user_input = input("Please enter a number (or type q to exit): ")
    if (user_input != "q"):
        total += int(user_input)
        count += 1
average = total/count
print("The average is", average)
