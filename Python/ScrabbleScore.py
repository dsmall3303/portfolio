
def WordScore(word):
    word = word.upper()
    score = 0
    for letter in word:
       if letter == 'F' or letter == 'H' or letter == 'V' or letter == 'W' or letter == 'Y':
           score = score + 4
       elif letter == 'K' or letter == 'J' or letter == 'X' or letter == 'Q' or letter == 'Z':
           score = score + 10
       else:
           score = score + 1
    return score



myScore = WordScore(input("Enter word to play: "))
print('Your Score:', myScore)
