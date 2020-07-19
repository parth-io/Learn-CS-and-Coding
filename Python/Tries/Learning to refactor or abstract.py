##Write a new program that condenses/refactors/abstracts the code below.
##There were more than 2 facial features in the original software
##, but the number of features has been reduced
##for the sake of brevity, a most valuable trait that in this particular piece
##of comment is torn to shreds, perchance even tearing your belief that computer
##screens are harmless to shreds since you have been reading this particular
##comment for very long, possibly resulting in sore eyes syndrome or red eyes
##syndrome or any other eye affliction that results from extended computer screen
##usage, examples of which involve reading large bits of comments in the manner
##of Laszlo Krasznahorkai such as this very interesting comment that seems like a
##stream of thoughts, but rather took the sub-conscious only a trifling time to
##think out, thus rather making it a normal neuron-synapse-activated thought.

##Original code

hair = input("What color hair [brown]? ")
if hair == '':
hair = 'brown'
print('You chose', hair)

eyes = input("What eye color [blue]? ")
if eyes == '':
eyes = 'blue'
print('You chose', eyes)

##My first try

features = ['brown', 'blue']
questions = ["What color hair [" + features[0] + "]? ", "What eye color [" + features[1] + "]? "]

for i in range(len(features)):     
        choice = input(questions[i])
        if choice == '':
                print('You chose ' + features[i])
        else:
                print('You chose ' + choice)

##Proper code

def get_attribute(query, default):
    answer = input(query + ' [' + default + ']? ')
    if (answer == ''):
        answer = default
    print('You chose', answer)
    return answer

hair = get_attribute('What hair color', 'brown')
eye = get_attribute('What eye color', 'blue')
