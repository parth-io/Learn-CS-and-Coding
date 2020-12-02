cache = {}

def fibonacci(n):
    global cache
    if n in cache:
        return cache[n]

    if n == 0:
        result = 0
    elif n == 1:
        result = 1
    else:
        result = fibonacci(n-1) + fibonacci(n-2)
##Saving the value of the result to the key n in the dictionary cache makes the code efficient. What happens if you don't do this is pretty ugly.
    cache[n] = result
    return result
