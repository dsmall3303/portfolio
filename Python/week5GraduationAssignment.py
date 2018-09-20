#inputs
gpa = 0.0
total_credits = 0
math_and_science_credits = 0
english_credits = 0
social_studies_credits = 0

user_input=''

#outputs
output = ''

#internal variables
gpa_requirement_met = False
total_credits_met = False
number_of_special_requirements_met = 0

#INPUT
user_input = input('What is the GPA? ')
gpa = float(user_input)

user_input = input('What is the total credits? ')
total_credits = int(user_input)

user_input = input('What is the number of Math and Science credits? ')
math_and_science_credits = int(user_input)

user_input = input('What is the number of English credits? ')
english_credits = int(user_input)

user_input = input('What is the number of Social Studies credits? ')
social_studies_credits = int(user_input)

#PROCESSING

#Otherwise the student will not graduate this year.
output = 'Not Graduate ):'
#Student will graduate IF:
##GPA>=2.0
if gpa >= 2.0:
    gpa_requirement_met = True


##Total creds >=40
if total_credits >= 40:
    total_credits_met = True

##at least two of the following are met:
###Math and Science creds >=6
if math_and_science_credits >= 6:
    number_of_special_requirements_met += 1
###English creds >=8
if english_credits >= 8:
    number_of_special_requirements_met += 1
###Social Studies creds >=4
if social_studies_credits >= 4:
    number_of_special_requirements_met += 1
#If the student does not meet both the minimum GPA and Total Credits requirement but does meet at least two of the special requirements the student can attend summer school.
if number_of_special_requirements_met >= 2 and (gpa_requirement_met == False and total_credits_met== False ):
    output = 'Summer School'

#If the student meets both the Min GPA and Total Credits requirements but only meets one of the special requirements, the student can attend summer school.
if number_of_special_requirements_met < 2 and (gpa_requirement_met == True and total_credits_met == True ):
    output='Summer School'

if number_of_special_requirements_met >= 2 and (gpa_requirement_met == True and total_credits_met == True ):
    output='Graduate!'

#OUTPUT
print(output)
