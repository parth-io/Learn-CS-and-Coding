##See the while loop for use of Boolean values
full = False

donations = []
full_load = 45

toys = ['robot', 'doll', 'ball', 'slinky']

while not full:
    for toy in toys:
        donations.append(toy)
        size = len(donations)
        if (size >= full_load):
            full = True
  
print('Full with', len(donations), 'toys')
print(donations)

##See below for use of Boolean values again
has_coconut = [True, False, False, True, False]

length = len(has_coconut)

for i in range(length):
##We could have written has_coconut[i] == True, but unnecessary
    if has_coconut[i]:
        print(smoothies[i], 'contains coconut')
