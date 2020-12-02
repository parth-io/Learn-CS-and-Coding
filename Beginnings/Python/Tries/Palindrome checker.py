##My try:
def c(i):
	j = (x - 1) - i
	if word[i] == word[j] and y == True:
		y = True
	else:
		y = False
	return y

def p(word):
	global x
	global y
	x = int(len(word))
	print(x)
	y = True
	if x%2 == 1:
		for i in range(int((x/2)-1)):
			y = c(i)
	else:
		for i in range(int(x/2)):
			y = c(i)

	return y

##Better:
def is_palindrome(word):
    i = 0
    j = len(word) - 1
    while i < j:
        if word[i] != word[j]:
            return False
        i = i + 1
        j = j - 1
    return True

##Even better:
def is_palindrome(word):
##The below line means empty strings are also palindromes.
    if len(word) <= 1:
        return True
    else:
        if word[0] == word[-1]:
           return is_palindrome(word[1:-1])
        else:
            return False
 
 
