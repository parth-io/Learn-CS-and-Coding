def drink_me(param):
        msg = 'Drinking ' + param + ' glass'
        print(msg)
        param = 'empty'
##If you didn't include the return line, the param variable and its value
##'empty' will disappear, leaving the value of drink_me(glass) as 'full'.
        return param

##Take note, you are passing the 'full' to the drink_me function,
##not the variable glass. As if this is something I should note.
glass = 'full'
glass = drink_me(glass)
print('The glass is', glass)

