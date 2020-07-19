#Mission Statement: Find the cube root of a perfect cube.
#If you had to plan this out, I imagine your orignal code would have been a lot
#more convoluted than what is below. See the author's genius.
x = int(input('Enter an integer: '))
ans = 0
while ans*ans*ans < abs(x):
    ans = ans + 1
    #if you want to check the code, uncomment the line below
    #print('current guess =', ans)
if ans*ans*ans != abs(x):
    print (x, 'is not a perfect cube')
else:
    if x < 0:
        ans = -ans
print('Cube root of ' + str(x) + ' is ' + str(ans))

#But the above block of code is wrong! It prints out the wrong statements when
#x is a negative number and not a cube root of a perfect cube, for example the
#integer -2. So what can be done to remedy this?

x = int(input('Enter an integer: '))
ans = 0
while ans*ans*ans < abs(x):
    ans = ans + 1
    #if you want to check the code, uncomment the line below
    #print('current guess =', ans)
    
if ans*ans*ans == abs(x):
    if x < 0:
            ans = -ans
    print('Cube root of ' + str(x) + ' is ' + str(ans))
else:
    print (x, 'is not a perfect cube')

#Smart, right?
#Well, we ain't done yet. A for loop is better for this program. My try below:
x = int(input('Enter an integer: '))
for i in range(0, abs(x)):
    cube = i**3
    if cube == abs(x) and x > 0:
        print('Cube root of ' + str(x) + ' is ' + str(i))
    elif cube == abs(x) and x < 0:
        i = -i
        print('Cube root of ' + str(x) + ' is ' + str(i))
    else:
        print(x, 'is not a perfect cube')

#Prof. John Guttag's try below:
x = int(input('Enter an integer: '))
for i in range(0, abs(x)+1):
    if i**3 == abs(x):
        break
if i**3 != abs(x):
    print(x, 'is not a perfect cube')
else:
    if x < 0:
        i = -i
    print('Cube root of ' + str(x) + ' is ' + str(i))

#Well, we ain't done yet. You thought otherwise? Stupid slime-covered lickball.
#The above program was too simple. Try the one below. We are using exhaustive
#enumeration (guess and check).
x = int(input('Enter an integer: '))
epsilon = 0.01
numGuesses = 0
ans = 0.0
while abs(ans**2 - x) >= epsilon and ans <= x:
#For some reason, your decrementing function is ans <= x and not abs(ans**2 - x).
#ans <= x will guarantee the termination of your program, while abs... is not a
#guarantee but only helps optimises the termination of the loop.
    ans += 0.00001
#We picked a random number for the incremen, but it has to be > epsilon.
    numGuesses += 1
print('numGuesses =', numGuesses)
if abs(ans**2 - x) >= epsilon:
    print('Failed on square root of', x)
else:
    print(ans, 'is close to square root of', x)

#Improved? We are now using the bisection search method.
x = int(input('Enter an integer: '))
epsilon = 0.01
numGuesses = 0
low = 0.0
high = x
ans = (high + low)/2.0
while abs(ans**2 - x) >= epsilon and ans <= x:
    #print low, high, ans
    numGuesses += 1
    if ans**2 < x:
        low = ans
    else:
        high = ans
    ans = (high + low)/2.0
#print 'numGuesses =', numGuesses
print(ans, 'is close to square root of', x)

def withinEpsilon(x, y, epsilon):
    """x, y, epsilon all ints or floats
       returns true if x is within epsilon of y"""
    return abs(x - y) <= epsilon

if withinEpsilon(25, 26, 1):
    print 'yes'
else:
    print 'no'

if withinEpsilon(25, 26, 0.9):
    print 'yes'
else:
    print 'no'
