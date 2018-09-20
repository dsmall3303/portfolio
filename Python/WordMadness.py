#variable declaration and initialization
VOWELS = "aeiou"
CONSONANTS = "bcdfghjklmnpqrstvwxz"
user_input = "x"
mode = "x"
test_word = "x"
y_enabled = "x"
more_words = "x"
done_con = False
num_targets = 0
num_words = 0
average_targets = 0

#check if the program will be running in consonant or vowel mode
while user_input[0].lower() != 'v' and user_input[0].lower() != 'c':
    user_input = input ("Would you like to check for vowels or consonants? ")
    if user_input[0].lower() != 'v' and user_input[0].lower() != 'c':
        print("I'm sorry, I didn't quite catch that. Say again?\n");

#get the first word
while (more_words[0].lower() != 'n'):
    test_word = input("Please enter a word: ")

#vowel mode
    if user_input[0].lower() == 'v':
        while y_enabled[0].lower() != 'y' and y_enabled[0].lower() != 'n':
            y_enabled = input("Is 'y' a vowel? ")
        if y_enabled[0].lower() == 'y':
            for letter in test_word:
                if letter.lower() in VOWELS or letter.lower() == 'y':
                    num_targets += 1   
        else:
            for letter in test_word:
                if letter.lower() in VOWELS:
                    num_targets += 1
#consonant mode
    elif user_input[0].lower() == 'c':
        while y_enabled[0].lower() != 'y' and y_enabled[0].lower() != 'n':
            y_enabled = input("Is 'y' a vowel? ")
        if y_enabled[0].lower() == 'y':
            for letter in test_word:
                 if letter.lower() in CONSONANTS:
                     num_targets += 1
        else:
            for letter in test_word:
                if letter.lower() in CONSONANTS or letter.lower() == 'y':
                    num_targets += 1
    num_words += 1
## Error checking???
##    while more_words[0].lower() != 'y':
##        if more_words[0].lower() != 'n':
    more_words = input("Would you like to enter another word? ")
##        if more_words[0].lower() != 'y':
##            if more_words[0].lower() != 'n':
##                print("Stop being silly.")
            
#processing...
average_targets = num_targets/num_words
if user_input[0].lower() == 'v':
    print("The average number of vowels per word is", average_targets)
else:
    print("The average number of consonants per word is", average_targets)
