## Why do they do this on HackerRank for Python when inputting arrays?
arr = list(map(int, input().rstrip().split()))
Basically, get input, rstrip it, split it, map makes each number an int, list combines this all back to a list


##See how the below line has a function in a function
dog_age = int(input("What is your dog's age? "))

##Using random.choice
choices = ['rock', 'paper', 'scissors']
computer_choice = random.choice(choices)

##The for loop in the first line here assigns a variable, word, to every item
##in the list. Comepare with the for loop in the second line, which assigns i
##to a number.
for word in ['ox', 'cat', 'lion', 'tiger', 'bobcat']:
    for i in range(2, 7):
        letters = len(word)
        if (letters % i) == 0:
            print(i, word)

##The below line, only in Python, would create [‘secret', ‘secret', ‘secret',
##‘secret', ‘secret']
m = ['secret'] * 5
##secretsecretsecretsecretsecrets
m = 'secret' * 5

##for loop statement formats 
for toy in toys
for i in range

##Creating a list of a certain range of numbers from 0 till the number equal to the length of the list inside minus 1 
ist(range(len(number))) 
