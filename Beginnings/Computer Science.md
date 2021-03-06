1. Terminology

   1. A script is a program – a sequence of expressions/commands 
   2. Variable – name for an object 
      1. Local vs Global variables 
         1. Scope - an area of the program where you can access a variable 
      2. Parameters 
         1. Essentially local variables with a special purpose of being fixed to the value of corresponding incoming arguments 
   3. Assignment statement – used to bind a name to an object 
   4. Expression – sequence of operands, operators and functions that can be interpreted into a value 
   5. Operands – variables and literals are operands 
   6. Types – classification of objects 
   7. Branching (conditional and iterations (looping)) and straight-line programs 

2. Types of data and data structures 

   1. https://cs.stackexchange.com/questions/47237/are-strings-scalar 
   2. Scalar (using Python for examples) 
      1. int 
         1. 5/2 will give 2, the 0.5 is truncated 
         2. https://en.wikipedia.org/wiki/Fixed-point_arithmetic 
      2. float 
         1. Function that makes inputted number into an approximation of a real number 
         2. https://en.wikipedia.org/wiki/Floating-point_arithmetic 
         3. https://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html 
         4. https://stackoverflow.com/questions/588004/is-floating-point-math-broken 
         5. https://floating-point-gui.de/ 
      3. Booleans 
         1. Mathematical and logical operators produce Boolean values, which can be used with Boolean operators 
      4. none 
         1. For something temporary, If you don't know what the value will be/is 
         2. None is a value of type NoneType 
         3. Signifies the lack of value otherwise 
         4. Expressions can return None. 
      5. char 

   1. Non-scalar 
      1. Strings 
         1. Sequence of characters 
         2. Immutable, as opposed to mutable lists 
         3. https://stackoverflow.com/questions/8798403/string-is-immutable-what-exactly-is-the-meaning 
         4. https://stackoverflow.com/questions/1552301/immutability-of-strings-in-java 
   2. Literals (original notation of a specific data type data types) 
      1. Collections (data structures) 
         1. Lists 
         2. Tuples 
         3. Dictionaries/Hash maps 
            1. https://en.wikipedia.org/wiki/Associative_array 
         4. Sets 
         5. Arrays 
      2. Primitives 
         1. Strings 
         2. Integers and floating points 
         3. Booleans 
         4. None 

3. OOP 

   1. Classes in module →Constructor instantiates class → Sets attributes (instance variables) and methods → Object instance formed 
   2. Data types are classes, variables are instances 
   3. List(), float() and str() are classes ← constructors that take arguments ← we don’t need to call their class constructor in Python, it is understood 

4. Declarative and imperative statements 

   1. Declarative programs can be used to check results generated by imperative programs 

5. Pseudocode is useful 

   1. Creating flowcharts 
      1. Circle – start/finish 
      2. Rectangle – action 
      3. Diamond – choice 

6. Syntax, semantic (messed-up logic) and runtime (messed-up instructions) errors 

   1. Syntax – whether a sequence of characters is in order or well-formed ('I big am' is syntactically incorrect) 
   2. Static semantics – whether the well-formed sequence can have meaning ('I are big' is a static semantics error) 
   3. Semantics – if no static semantics errors, assigning meaning to a legal sentence (What does 'I am big' mean) 
   4. Errors can make programs crash, run forever or give wrong results 

7. Boolean logic 

   1. Boolean algebra 
   2. Truth tables 
   3. Logical connectives 
   4. Bitwise operations 

8. Overloaded operators 

9. Defining functions - abstractions 

   1. Improves efficiency, readability and ability to change code later easily 
   2. Call or invoke a function 
   3. Pass arguments/values into function calls 
   4. The function's zero or more parameters accept arguments/values from your function call 

10. Algorithms 

    1. Guess and check 
       1. Exhaustive enumeration 
    2. Calculation 
       1. Approximation 
          1. Use epsilon 
    3. Bisection search 
    4. Sorting 
       1. Bubble sort 
       2. Insertion sort 
       3. Merge sort 
       4. Quicksort 
       5. Timsort 
       6. https://en.wikipedia.org/wiki/Sorting_algorithm 
    5. Algorithmic analysis 
       1. https://en.wikipedia.org/wiki/Algorithmic_efficiency#See_also 
       2. https://en.wikipedia.org/wiki/Computational_problem 
       3. https://en.wikipedia.org/wiki/Computational_complexity_theory 
       4. https://en.wikipedia.org/wiki/Analysis_of_algorithms 
       5. https://en.wikipedia.org/wiki/Big_O_notation 
    6. Recursive 
       1. Recursive functions end when you reach the base case 
       2. Iterative vs recursive algorithms – depends on programming language, call stack overflow 
       3. Memoisation to avoid expensive recursive computations 
       4. Binary search tree 
       5. https://en.wikipedia.org/wiki/Tree_traversal/ 

11. Heuristics 

    1. Don't offer accurate solutions unlike perfect algorithms 
    2. Suitable when constrained by computing power requirements or context of the problem 
    3. Constant time 
       1. Time taken to perform a single operation 

12. File and text operations 

    1. Escape sequences 
       1. \n, \t, \b, \v 
    2. Relative and absolute paths 

13. Regular expressions for string operations 

14. OOP Principles 

    1. Inheritance 
    2. Abstraction 
    3. Polymorphism 

15. Unicodes and characters 

    1. ACSII, UTF-8, UTF-16, UTF-32 
    2. https://en.wikipedia.org/wiki/Variable-length_code 

16. Matrix Representation 

17. Input/output standard streams 

18. Software design 

    1. SOLID 
    2. Separation of concerns 
    3. Encapsulation 
    4. Pipeline 
    5. Everything is a file 
    6. https://en.wikipedia.org/wiki/Programming_paradigm 
    7. YAGNI 
    8. Extreme programming 
    9. https://en.wikipedia.org/wiki/Software_development_process 
    10. https://en.wikipedia.org/wiki/Software_development 
    11. https://en.wikipedia.org/wiki/Unix_philosophy 
    12. Worse is better 
    13. Don't repeat yourself 
    14. The Zen of Python 
    15. TMTOWTDI 