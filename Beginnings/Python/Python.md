1. Java vs Python 
   1. https://realpython.com/oop-in-python-vs-java/ 
   2. http://www.cs.colby.edu/courses/S20/cs231-labs/JavaVsPython.html 
   3. [http://math-cs.gordon.edu/courses/cps122/handouts-2016/From%20Python%20to%20Java%20Lecture/Key%20Differences%20between%20Python%20and%20Java.pdf](http://math-cs.gordon.edu/courses/cps122/handouts-2016/From Python to Java Lecture/Key Differences between Python and Java.pdf) 
   4. http://anh.cs.luc.edu/331/notes/JavaVsPython.html 
   5. https://www.rose-hulman.edu/class/csse/csse220/201130/Resources/Python_vs_Java.html 
2. Read later 
   1. https://stackoverflow.com/questions/7359828/how-to-repeat-a-function-n-times 
3. Note the syntax in these points 
   1. verbs = [‘Leverage’, ‘Sync’, ‘Target’] 
   2. phrase = verb + ‘ ‘ + ‘it’ + ‘.’ 
   3. Variable = input(“What’s yo name? ”) <-- note the space after the ‘?’ 
4. Concatenation 
5. Double hash is used to comment out a line, single hash is used to comment out only whatever is written on the line after the hash 
6. To break a line of code into many lines of code, use parentheses 
7. To enter multiline text, use triple quotes 
8. Docstrings in Python – use multiline strings at the top of the module and below defined function 

#### List of keywords 

1. input 
   1. Creates strings 
2. print 
   1. Adds space between multiple arguments 
3. false 
4. as 
5. continue 
6. from 
7. ** for exponentiation, - for negation of a number, % for remainder, > and <=, == and != 
8. In 
   1. Boolean operator 
   2. Check if value is in the sequence (a string and a list both are sequences) 
9. not, and, or 
   1. Boolean operators 
10. return 
11. none 
12. assert 
13. def 
14. except 
15. global 
16. is 
17. try  
18. break 
19. del 
20. finally 
21. lambda 
22. pass 
23. class 
24. nonlocal 
25. raise 
26. with 
27. list 

#### Importing some common libraries and classes 

1. random 
   1. .randint(x,y) 
   2. .choice(list) 
   3. .math 
2. sys 
   1. A lot of shit 
   2. argv 
   3. Exceptions 
3. import json, os 
4. from turtle import Turtle, Screen 
5. import tkinter as Tk 

Functional Programming Modules 

- itertools 
- functools 
- operator 

#### Notes

1. len(list_name) 

   1. Gives the length of a list 

2. Change 1 data type to another using the int, str and float functions 

   1. Use type to find the type of the data 
   2. -int(2.1) will truncate the float to just 2; you cannot convert a string with a floating number, say int(‘3.0’), to int in Python 
   3. Input in Python will interpret what user enters as a string 

3. range(starting number, ending, step) 

   1. Creates a sequence that starts from the 'starting number' and ends at a number that is one less than the 'ending' 

4. Looping and conditions 

   1. Sequences – list, string, text, tuple, etc. 
   2. while 
      1. Looping over some condition; don't know how many loops are needed 
      2. Can use i as an index to point to an entry in a list 
      3. Used for general looping 
   3. for 
      1. Looping/Iterating over a sequence of values or a range (use the range function); number of loops are known 
      2. Better than while when doing iteration over a list of fixed number of item 
   4. If, elif and else statements for conditions 

5. Defining functions 

   1. def function_name(parameter_1, parameter_2): 

      function body 

      return value 

   2. Can use local variables 

   3. Use return to get back a value 

      1. If a function doesn’t have a return statement, it returns None. 
      2. Anything after a return statement is not executed 

   4. So when defining a function, inside the function body, your local variable and parameter can be similarly named to your global variable 

      1. Your function body shouldn't refer to any global variables 
      2. But if you do want it to, use the global keyword inside the function body 
         1. global name_of_global_variable 
         2. You can change the value of a global variable inside a function body if so desired 
            1. But if you do not use the global keyword and decide to change the value 
               1. Either it is the first time you have used this variable in your function and Python will take it to be a local variable 
               2. Or you have already read the value once and Python will throw an UnboundLocalError 
      3. Default parameter 
         1. def function_name(required_parameter, non-required_parameter=default_value): 
            1. Always list required parameters 

6. Arguments can be positional or keyword-based 

   1. Positional – corresponding parameters and arguments are linked 
   2. Keyword - when defining a function, the parameter name also functions as a keyword 
   3. Example: 

   def life(k, d): 

   print(k, d) 

   life(d = 2, k = 4) 

   life(4, 2) 

7. Nested loops and bubble sort algorithm 

   1. See sample code 
   2. Words are sorted lexicographically 

8. Collections 

   1. To access an item in the list we use this syntax: list_name[index of the item]. Indices, like many things, start from 0. 
   2. To change the value of an index, do new value = list_name[index]. 
   3. For Python only – use negated numbers as indices in reverse order (-1 is the list's last item) 

9. Lists 

   1. list(range(number)) will give you a list with the range of numbers specified 

   1. list_name.append('item or value to add to list') 
   2. del list_name(index number)) to delete an item in the list 
   3. list_name.extend([new list]) to extend a list 
   4. list_name = list_name + ['item 1', item 2'] to combine two lists (similarly in purpose to extend, but creates a new list) 
   5. list_name.insert(index to insert item at, item) 
   6. len(list_name) gives length 
   7. Can create lists with different data types 
   8. List comprehension 
      1. squares = list(map(lambda x: x**2, range(10))) 
      2. squares = [x**2 for x in range(10)] 

10. Append vs extend 

    1. If you append [1, 2, 3], all 3 items will be appended as one new item to the original list; extend will add them as separate items 
    2. Multiplication of number and list vs multiplication of number and string 

11. For text that spans multiple lines, enclose the text with triple quotes. 

12. Importing modules – access variables and functions inside an imported module by prepending the module name and a dot 

13. Dictionaries 

    1. https://www.w3schools.com/python/python_dictionaries.asp 
    2. https://stackoverflow.com/questions/4406501/change-the-name-of-a-key-in-dictionary 
    3. https://www.tutorialspoint.com/How-to-replace-values-of-a-Python-dictionary 

14. Del statement 

15. _ underscore use 

    1. https://www.datacamp.com/community/tutorials/role-underscore-python 
    2. https://stackoverflow.com/questions/5787277/python-underscore-as-a-function-parameter 
    3. https://stackoverflow.com/questions/57197032/what-does-mean-in-lambda-function-and-why-is-it-used 
    4. https://stackoverflow.com/questions/29767310/pythons-lambda-with-underscore-for-an-argument 
    5. https://stackoverflow.com/questions/5893163/what-is-the-purpose-of-the-single-underscore-variable-in-python 
    6. https://hackernoon.com/understanding-the-underscore-of-python-309d1a029edc 

16. Strings 

    1. split 
       1. Splits a variable of type string into substrings by using delimiters (by default, it uses whitespace, but it can also use other characters 
    2. string[i] will give you a character 
    3. Slicing a string and a list 
       1. substring = string_name[i_start:(i_end + 1)] 
    4. Strip 
       1. S 

17. open class (close, read, readline methods) 

    1. The last line of any text has an empty string, i.e. ‘ ‘. 

18. list = variable.split() 

    1. the split function works, like a lot of other functions, by being attached to a data type 

19. time.time() is useful as a gauge of computational complexity 

20. Python global variable __name__ 

    1. Use this variable to check if your program is the main program with value __main__ or a module (the value will be the module’s name), and then let the program act accordingly 

21. Handling exceptions → see Python Tutorial and Standard Library 

    1. Bad idea to omit exception name and let one exception clause handle all exceptions 
    2. Can catch multiple exceptions with one except clause with parentheses: for example, except (FileNotFoundError, OSError) 

22. List and array notation – see link in Firefox →[x][x]; [x:]; [:x]; [x:y] 

    1. https://sites.google.com/site/aslugsguidetopython/data-analysis/array-manipulation 
    2. https://www.learnbyexample.org/python-nested-list/ 
    3. Creating grids 
       1. Use lists within lists 
          1. Do [0] * number_of_rows, then [0] * number_of_columns for each value in the row 
    4. Array[start:end:step] 
       1. Array[::3] means beginning from index 0, take every third item of the array. 

23. Python if/in statements 

    1. if x in y –> x in y will return True, so if True, then the if statement is executed 

24. Printing statements 

    1. Normal 

    2. Use .format - https://pyformat.info/ 

    3. f' - https://docs.python.org/3/tutorial/inputoutput.html 

    4. To change the space separation in print, use sep and end. 

       1. print(1, 2, 3) 

       \#1 2 3 

       print(1, 2, 3, sep='') 

       \#123 

       1. print(1, 2, 3, end='') 

       print(4, 5, 6) 

       \#1 2 3 4 5 6 

25. *, * * operators 

    1. \* is an overloaded operator 
       1. In one use, it unpacks lists 
          1. For example, if L is a container (list, set, etc.), then *L will unpack its contents in order with default separator whitespace 
    2. https://treyhunner.com/2018/10/asterisks-in-python-what-they-are-and-how-to-use-them/ 
    3. https://stackoverflow.com/questions/36901/what-does-double-star-asterisk-and-star-asterisk-do-for-parameters?rq=1 

26. Abstract Base Classes 

27. Python ternary operator expression 

    1. value_when_true if condition else value_when_false 
       1. Example 
          1. 'Yes' if fruit == 'Apple' else 'No' 

28. Python whitespace rules 

    1. https://www.python.org/dev/peps/pep-0008/#pet-peeves 

29. For each 

    1. for x in y: 

       do something 

30. Assigning values 

    1. Assign the same value to multiple variables, a, b and c 
       1. If the value is a list, [1, 2, 3], and if you change one of the elements in the list, add an element, etc., the variables a, b and c will all point to the update list 
       2. Use the is operator to check for equality of identity or the id function 
       3. However, if the value is an immutable type, like integer, and you assign it to the variable a, a will point to the new value and b and c to the list 
       4. [value] * number_of_variables 
          1. https://stackoverflow.com/questions/33331732/python-initialize-multiple-variables-to-the-same-initial-value 
       5. Use lambda function 
       6. Dictionary comprehension 
       7. Inverse dictionary 
          1. https://stackoverflow.com/a/5495556 
    2. Assign values to multiple variables in the same line 

31. Generators or Iterators 

    1. Yield statements 

32. zip() function 

33. Tuple comparisons 

34. ~ operator 

35. Override the __str__ method to print a description when print is called on the object 

36. Decorators 

    1. @ syntax 

37. Flexibility of Python's functions 

    1. First-class functions 
       1. Assign a function to a variable 
       2. Pass a function to another function 
    2. Higher-order functions 
       1. Return a function from a function 
          1. Yes! Function calls can return functions that contain variables 

38. Graphical interfaces with Tkinter 

    1. Interface components – widgets 
    2. Tkinter has numerous layout managers 
    3. tk object represents a main window 
    4. Event objects are passed to handler functions when a bind method registers an event 
    5. You can auto-call an object after a certain amount of time has elapsed 
    6. StringVar – used to store, retrieve and track changes to a variable’s value, used with OptionMenu 

39. Overloaded functions 

    1. Parameter defaults 

40. Web APIs 

    1. Use requests packages (download using PIP) 
    2. https://en.wikipedia.org/wiki/List_of_HTTP_status_codes 
    3. Headers 

41. is operator 

42. Function id 

    1. The function id returns the location of an object in memory. If the id of 2 variables is the same, they are referring to the same object. 

43. Slice Operator/Slice function for lists 

    1. https://stackoverflow.com/questions/509211/understanding-slice-notation 
    2. https://stackoverflow.com/questions/4486382/slice-operator-understanding 

44. Enumerate() and join() 