x = 10
y = x
y = x + 1
if id(x) is id(y):
    print("true")
else:
    print("false")
##x and y will have different ids, as y will point to a new object in a different memory location with a different id as integers are immutable objects.

x = [0, 1, 2]
y = x
y.pop()
if id(x) is id(y):
    print("true")
else:
    print("false")
##In this case, once y is modified, the object itself is changed as lists are immutable and therefore x will continue to point to the same object.
