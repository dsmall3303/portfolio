user_input = ""
output_string = ""
index = 0

user_input = input("Please enter a word: ")
index = len(user_input)-1
while index >=0:
    output_string += user_input[index]
    index -=1
print(output_string)
