#Write a program that prints out numbers from 0 to 30. However, for multiples of
#3, print 'Fizz' instead of the number; for multiples of 5, print 'Buzz'; and
#for multiples of 3 and 5 print 'FizzBuzz'.

#My code is below

for i in range(1, 31):
    if i % 3 == 0 and i % 5 == 0:
        s = 'FizzBuzz'
    elif i % 3 == 0:
        s = 'Fizz'
    elif i % 5 == 0:
        s = 'Buzz'
    else:
        s = str(i)
    print(s)

#See how much more better this code is, you silly twat

for i in range(1, 31):
    s = str(i)
    if i % 3 == 0 or i % 5 == 0:
            s = ''
            if i % 3 == 0:
                s = s + 'Fizz'
            if i % 5 == 0:
                s = s + 'Buzz'
    print(s)
