### Overview

A quick recap of Java

[TOC]

*Italicised stuff is stuff I did not understand at the point of writing*

### To Do

1. Review content
2. Remove the links to a different location, and leave only content here
3. Align the topics to and arrange using the syllabus of Java courses and books
4. Transfer content over from bookmarks to here
5. *Remove italicised stuff if understood*

https://docs.oracle.com/javase/tutorial/, https://docs.oracle.com/javase/8/docs/api/index.html and https://docs.oracle.com/javase/8/docs/.  

https://en.wikipedia.org/wiki/Liskov_substitution_principle 

https://www.journaldev.com/37273/java-14-features 

JUnit testing framework 

Cracking the Coding Interview: 150 Programming Questions and Solutions book 

https://www.java2novice.com/java_interview_questions/ 

Google's Gauva 

Apacha Common Lang/Utils 

https://marcus-biel.com/ 

https://www3.ntu.edu.sg/home/ehchua/programming/ 

### Java's Basics, Semantics, Syntax 

1. Data Types, Arrays - https://www.hackerrank.com/challenges/30-arrays/tutorial, https://www.javatpoint.com/java-data-types
   1. Characters
      1. https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
2. Class, Variable, Function, Method, Object, Stream, Fields, Constructors - https://www.hackerrank.com/challenges/30-hello-world/tutorial 
   1. Instances of Java classes are objects
      1. Self-referential classes
         1. https://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/linkedlists/index.html
      2. Instance variables, local variables and class variables
         1. Instance variables have object-level scope, being defined in a class; local variables have a block-level scope, being defined in a method or loop; class (static) variables have a class-level scope. 
            1. Therefore, you cannot access local variables from outside the method, you must declare them outside the method 
         2. Constructors do not have a return statement, they simply assign the values that are the constructor's arguments to the class' instance variables which are normally private, and if required, final - thus, each object has its own set of instance variables with values that are from the constructor's arguments
         3. *Did not understand why local variables are not initialised to any default values unlike class or instance variables*
            1. https://stackoverflow.com/questions/415687/why-are-local-variables-not-initialized-in-java
            2. https://stackoverflow.com/questions/268814/uninitialized-variables-and-members-in-java
            3. https://stackoverflow.com/questions/1542824/initialization-of-instance-fields-vs-local-variables
            4. https://stackoverflow.com/questions/22811261/why-local-variable-must-be-initialized-and-why-instance-variables-must-not-be-in
            5. https://softwareengineering.stackexchange.com/questions/361502/why-doesnt-java-automatically-initialize-local-variables-with-its-default-value
         4. Local variables shadow instance variables, to access instance variable, use this.instanceVariable
            1. Constructor parameters can shadow instance variables
         5. Neither can you have static fields inside a method, nor can you have a static field in an inner class (for why, see https://stackoverflow.com/questions/1953530/why-does-java-prohibit-static-fields-in-inner-classes)
      
   2. Static methods and variables
      
      1. Static methods can be called without having to create an object of the class to which the static method belongs
      2. You cannot access non-static members of a class from a static context
      3. Static fields and methods are not thread-safe 
         1. *Did not understand this*
            1. Initialization is an important aspect of a static block. Static fields or variables are initialized after the class is loaded into memory. The order of initialization is from top to bottom, in the same order in which they are declared in the source file of the Java class. Since static fields are initialized in a thread-safe manner, this process is also used to implement the Singleton pattern. If you are not using an Enum as a Singleton for some reason, then you have a good alternative. But in this case, you must take into account that this is not a "lazy" initialization. This means that the static field will be initialized even BEFORE someone "asks" for it. If an object is resource-heavy or rarely used, then initializing it in a static block won't work in your favor.
            2. https://www.geeksforgeeks.org/singleton-class-java/, https://en.wikipedia.org/wiki/Singleton_pattern
            3. singleton class vs enum
            4. Singleton classes, singleton classes using enum
            5. DayOfWeek class' Enum constants are singleton instances – what does this mean
         2. Did not understand also
            1. During serialization, static fields, like transient variables, are not serialized. Indeed, if you save any data in a static field, it will contain its initial (default) value after deserialization. For example, if a static field is an int, its value will be zero after deserialization. If its type is float, the value will be 0.0. If the field is an Object, the value will be null. To be honest, this is one of the most frequently asked questions about serialization in interviews for Java positions. Don't store essential object data in a static field!
      
   3. Method parameters are pass-by-value - https://dzone.com/articles/java-pass-by-reference-or-pass-by-value, http://www.javadude.com/articles/passbyvalue.htm, https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value?rq=1, https://stackoverflow.com/questions/373419/whats-the-difference-between-passing-by-reference-vs-passing-by-value#comment102368162_430958
      1. Java is strictly pass-by-value
   
         1. For primitives, copies of values are passed
         2. For objects, copies of the object's values are passed - but as the value of an object is its reference, the same object is passed
   
         1. Except in the case of strings which are immutable, treat strings as primitives or use StringBuilder
   
      2. This distinction applies when checking for object reference equality, as compared to object value equality - using == vs String.equals()
   
   4. Initialising fields
      1. Traditional way - declaring and initialising fields in one-line at the start of the class body
      2. Alternatives
         1. To initialise instance members
            1. Initialiser blocks
               1. They initialise instance members after an instance is created and before the constructor is called
               2. Therefore, useful in sharing a common block of code across constructors
            2. Final methods
            3. Static initalisation blocks
               1. For complex initialisation, like try-catch block or conditionals
               2. Initialised before any objects of the class are created
   
   5. *Did not understand*
   
      1. https://stackoverflow.com/questions/4694661/declaring-java-object-given-its-type-class-name-as-string
3. Access Modifiers and Annotations (javadocs - https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#format, https://docs.oracle.com/javase/7/docs/technotes/tools/solaris/javadoc.html#leadingasterisks) 
   1. private public default protected
   2. abstract final static
4. Operators - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
   1. Boolean and ternary (ternary operator ? can replace if-else statements https://stackoverflow.com/questions/4192225/prettiness-of-ternary-operator-vs-if-statement, https://www.programiz.com/java-programming/ternary-operator)
   2. Bitwise and Conditional Operators
      1. Bitwise operators have integer, byte, long, etc. Operands
         1. Can be used to check for odd/even numbers
         2. Can be used as logical operators also, but not recommended
      2. Conditional operators are logical operators and have boolean operands, but they follow short-circuit evaluation
   3. Operator precedence – bitwise operator & is lower than == 
   4. ~ 
      1. Performs a bitwise NOT operator thtat flips the bits of the number 
      2. If the number system is using two's complement, the effect is of negating a positive number's sum with 1 
5. For, while and do-while statements
6. Object Creation
   1. Declaration, Insstantiation and Initialisation
      1. https://stackoverflow.com/questions/2330767/what-is-the-difference-between-instantiated-and-initialized
      2. https://stackoverflow.com/questions/15074083/difference-between-initializing-a-class-and-instantiating-an-object
      3. https://stackoverflow.com/questions/32290879/meanings-of-declaring-instantiating-initializing-and-assigning-an-object

### Java Tips

1. Java.lang.class (see https://www.geeksforgeeks.org/java-lang-class-class-java-set-1/ for ways to instanstiate an object of type Class; one way to use its methods is System.out.println(Arrays.toString(this.getClass().getMethod("test", null).getDeclaringClass().getInterfaces())); .getClass returns runtime class, while .getDeclaringClass returns class returns the class in which the object was declared)
2. Double colon method reference operator - https://stackoverflow.com/questions/28023364/what-is-the-equivalent-lambda-expression-for-system-outprintln/28025717#28025717, https://stackoverflow.com/questions/31020269/what-is-the-use-of-system-outprintln-in-java-8, https://stackoverflow.com/questions/20599579/why-must-we-use-double-colons-for-method-references, https://www.baeldung.com/java-8-double-colon-operator, https://www.geeksforgeeks.org/double-colon-operator-in-java/
3. Lists and Arrays
   1. List interface – ArrayList vs LinkedList (https://www.javatpoint.com/difference-between-arraylist-and-linkedlist)
   2. ArrayList vs Array
      1. ArrayList's forEach() method
      2. (element) -> action
   3. ArrayList vs List
   4. ArrayList vs LinkedList
      1. https://javahungry.blogspot.com/2015/04/difference-between-arraylist-and-linkedlist-in-java-example.html
   5. To convert from a Collection that contains objects of type Foo to an array, do this: Foo[] foos = x.toArray(new Foo[x.size()]);
   6. https://www.geeksforgeeks.org/convert-an-arraylist-of-string-to-a-string-array-in-java/
   7. Convert array to String
      1. ​	Use StringBuilder append(char[] ) method
         1. Arrays.toString()
      2. ListIterator and Iterator interfaces
         1. listIterator() method
4. Use StringBuilder class in Java to create mutable strings (stings in Java are immutable, therefore operations on strings can create high memory overload)
5. for i : x – for each i in an array x
6. To return multiple values from one method, you will need to need to put the values in one object (I.e. a class or list) - https://www.geeksforgeeks.org/returning-multiple-values-in-java/
7. Break and continue statements
   1. Use labels for nested loops - https://stackoverflow.com/questions/886955/how-do-i-break-out-of-nested-loops-in-java
8. Switch statements
9. Primitive types
   1. When doing division, be careful – if you use integer for division, any non-integer answer will be truncated to an integer, even if you are storing the result of the division to a float or double. Therefore, always use double number in number operations, or cast to double or float
      1. Don't cast the entire expression, but rather cast only the integer numerator or denominator or both to double. Otherwise, integer division will be performed, returning an integer result which is then casted to double.
      2. Implicit or explicit casting
         1. https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double/36471636#36471636
         2. Implicit casting (for upcasting)
            1. Write nothing extra, just declare a wider data type and initialise to the narrower data type's value
               1. Double x = y //where y is an int
            2. Double.valueOf()
            3. Double d = new Double(int)
            4. When doing math, multiply numerator or denominator by 1.0, or add 0.0
         3. Explicit (for downcasting) - (int) or Double.intValue()/longValue() or Math.round() or Number class' methods
   2. Beware of widening and narrowing conversions <u>- see bookmarks</u>
      1. Converting int to byte is widening
      2. Why can convert float to long  when float is 32 bit
   3. Use BigDecimal class for accuracy, or StrictMath class
      1. When constructing a BigDecimal object, always use a String instead of a primitive type for parameter – avoids issues with inexact values
   4. To round numbers/decimals
      1. Use BigDecimal class
         1. round() - when you want to get the number of significant digits
         2. setScale() - when you want to set the scale (number of digits to right of decimal point) - https://stackoverflow.com/questions/3843440/bigdecimal-setscale-and-round
      2. Use DecimalFormat
      3. Use Math.round() **(not recommended)**
         1. Multiply the decimal by 10^n to get a number that only has one decimal point, then round the new number, then divide by 10^n 
         2. Why this fails – you are multiplying a floating point digit, the result of the multiplication might not be what you expect, especially for values at the boundary edge of .5 
      4. External libraries
         1. Apache Commons Math – Precision.round() 
         2. decimal4j – DoubleRounder.round
      5. All literal numbers are taken to be integers, so for long numbers you can add a L
      6. .MIN_VALUE and .MAX_VALUE 
10. Input/Output
    1. printf or format method to choose format for output
       1. See Formatter class
          1. For the flag '0', must enter width after the flag
          2. String.format("%1$" +  number_of_spaces + "s", inputString).replace(' ', '0');
             1. Format 1st argument which is a string as right-justified and with spaces appended, then replace spaces with 0s
          3. System.out.printf("%-8d%-8d%-8.7g\n", x, y, fraction)
             1. To print a table of 2 integers and a double
       2. For numbers, you can still use the two methods above or use DecimalFormat
    4. InputStream class is for reading bytes 
       1. Wrap a FileInputStream in a InputStreamReader object if you are reading text with a different encoding, as FileReader uses the default platform encoding 
    3. Some input classes (Java has io and nio)
       1. Google 'fastest way to write/read data from huge files', 'fastest way to write to a file'
       2. https://www.tutorialspoint.com/java/java_files_io.htm
       3. https://stackoverflow.com/questions/21817816/java-reading-a-file-different-methods; https://stackoverflow.com/questions/22749096/efficient-way-to-read-a-file-java
       4. Broadly similar to the Output classes
       5. Reader (abstract class)
          1. Subclasses of Reader such as InputStreamReader and BufferedReader
          2. BufferReader is used for costly/long input operations
             1. When do you not need BufferedReader - http://java-performance.info/java-io-bufferedinputstream-and-java-util-zip-gzipinputstream/
             2. It is a Decorater Pattern class
             3. To check for EOF in BufferedReader
                1. Either do while (null != (String_inputted = bufferedreader_object.readLine()))
                2. Or String s = r.readLine(); 
                   while (s != null) { 
                       // do something;  s = r.readLine();}
             4. https://medium.com/@isaacjumba/why-use-bufferedreader-and-bufferedwriter-classses-in-java-39074ee1a966
       6. Scanner
          1. https://www.hackerrank.com/challenges/30-data-types/tutorial
          2. nextLine() proceeds to the end of the current line, so you may need to use nextLine() twice
          3. Instead of using scan.nextLine() twice, you can use a loop to concatenate when there is next line: for (scan.hasNextLine()) {	st += scan.nextLine(); }
    4. Some output classes - https://howtodoinjava.com/java/io/java-write-to-file/#PrintWriter
       1. System.out
       2. Files.writeString()
       3. Files.write()
       4. BufferedWriter
       5. FileWriter
       6. PrintStream
       7. PrintWriter
          1. Formatted text
       8. FileOutputStream
          1. Binary data
       9. OutputStreamWriter
       10. DataOutputStream
           1. Primitive data types
       11. FileChannel
           1. Large files
    5. System.exit
    6. Strings and escape sequences
       1. Escape characters and UTF (unicode) values (signalled by a \) in strings from the input stream will be considered appropriately, however, the program will ignore any escape characters in text from files
          1. Either use Apache Commons Lang's StringEscapeUtils.unescapeJava(),
          2. Or take each \ separately, convert it to hexadecimal and then to a character
             1. https://stackoverflow.com/a/11145854/13742805
          3. Note on replaceAll() vs replace
             1. replaceAll takes a regular expression and not a string
                1. https://stackoverflow.com/a/1701876/13742805
       2. To escape an escape character, do the following:
          1. Use \\\
          2. char (92) will give you a \
          3. Read text from a file
11. Numbers, Currencies and Date and Time
    1. Date and Time
       1. Use the java.util.time.* libraries only
       2. Uses static factory methods and not constructors
       3. To convert an object to String, for example for DayOfWeek object of type enum
          1. Locale locale = Locale.getDefault(); and DayOfWeek_Object.getDisplayName(TextStyle.FULL, locale)
          2. DayOfWeek_Object.name()
             1. Enum class is parent class and it has an abstract method name()
    2. Currency
       1. NumberFormat's getCurrencyInstance(Locale locale) for currency format, then call the format() method
       2. You don't need to instantiate a NumberFormat object, just declare a variable of type NumberFormat and call the getInstance() method
          1. The getInstance method returns an object of type DecimalFormat, which is an implementing subclass of the abstract NumberFormat class
       3. Numbers
          1. DecimalFormat - https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
12. Because performance is important to graphics applications, and because it's faster to access an array element than to call a method, developers resort to performance tricks such as creating and initializing arrays of sines and cosines.
13. Assertion  
14. https://stackabuse.com/javas-object-methods-tostring/

### Stepping Up 

1. Exceptions – throw can be used to throw any exception, checked or unchecked; throws must be put in the method declaration if the exception is checked and you want throw the exception up the method call stack (no catch statement); throws allows the compiler and program to know that the given exception(s) can occur in the method - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

2. Streams vs Loops - https://blog.overops.com/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/, https://www.baeldung.com/java-collection-stream-foreach, https://blog.jooq.org/2015/12/08/3-reasons-why-you-shouldnt-replace-your-for-loops-by-stream-foreach/, https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops, http://cr.openjdk.java.net/~briangoetz/lambda/lambda-libraries-final.html, https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html
   1. Convert int array to String array via Streams
      1. https://www.techiedelight.com/convert-int-array-string-array-java/
   2. https://www.techiedelight.com/convert-int-array-string-array-java/
   
3. Threads

4. `This` - https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html

5. Lambda expression vs Anonymous class

6. Java collections - https://dzone.com/articles/an-introduction-to-the-java-collections-framework
   1. Maps interface
      1. Hash maps, Map interface, and Dictionary class
         1. https://www.geeksforgeeks.org/differences-treemap-hashmap-linkedhashmap-java/
         2. Dictionary class is obsolete
         3. Hash map uses Map interface
            1. https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable
            2. https://stackoverflow.com/questions/1348199/what-is-the-difference-between-the-hashmap-and-map-objects-in-java
         4. *Did not understand if/why HashMap must override equal() and hashCode() methods*
            1. why must hashmap have equals and hashcode
            2. https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
            3. https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java
            4. https://www.programcreek.com/2011/07/java-equals-and-hashcode-contract/
            5. hashCode() equals() hashmap
   
7. Generics; Classes; Types
   1. Formats
      1. Declaring object - Map<String, Integer> object = new LinkedHashMap<String, Integer>();
      2. Declaring variable – T variableName;
      3. Default constructor - <modifier> <T>ClassName() {}
      4. Method - <modifier> <T> type_of_returned_object methodName(T t) {}
         1. Using type witnesses when invoking methods – ClassName.<T>methodName(t) instead of ClassName.methodName(t)
   2. Bounded types
   3. *Wildcards*
      1. https://stackoverflow.com/questions/16707340/when-to-use-wildcards-in-java-generics, https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
      2. Do not understand why we need unbounded wildcards - Unbounded wildcards
         1. Say we want to print elements of a list with method `printList(List<Object> list)`
         2. It only prints a list of Object instances; it cannot print `List<String>`, `List<Integer>`, etc. because they are not subtypes 
         3. So we need to use generic printList method, use `List<?>`
         4. But this works also - `<T extends Object> printList(List<T> list)` - it prints strings and integers 
         5. So why do we need wildcards? We can still upper bounded type parameters 
         6. It's important to note that `List<Object>` and `List<?>` are not the same. You can insert an Object, or any subtype of Object, into a `List<Object>`. But you can only insert null into a `List<?>`.  
   4. Inheritance rules apply to generics
      1. They apply to the type arguments also
         1. An operation performed on a type argument, the class Number, is equally valid if performed on its subtypes, the classes Integer and Double, also
         2. Generic classes themselves can subtype
            1. `ArrayList<T>` is a subtype of `List<T>`, itself a subtype of `Collection<T>`
   5. Using arrays with generics
      1. One possible approach - `Item[] array = (Item[]) new Object[n]`
      2. This link will debate the pros and cons of each approach - https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
      3. https://www.softwaretestinghelp.com/java-generic-array/
   
8. https://stackoverflow.com/questions/2770321/what-is-a-raw-type-and-why-shouldnt-we-use-it

9. Covariance and contravariance - https://dzone.com/articles/covariance-and-contravariance, https://stackoverflow.com/questions/2770264/what-is-the-difference-between-e-extends-number-and-number/, https://www.freecodecamp.org/news/understanding-java-generic-types-covariance-and-contravariance-88f4c19763d2/

10. *Could not understand* - https://stackoverflow.com/questions/2745193/why-is-using-collectionstring-class-illegal

11. Variable-length arguments (varargs)

12. Converting types - https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1

13. Inner (nested) classes
    1. Inner classes can be static
    2. Non-static inner classes cannot have static fields or methods

    1. Inner methods alternatives

       1. https://www.geeksforgeeks.org/method-within-method-in-java/

14. Manipulating and searching strings
    1. Use String class methods – for example, String.split(String regex)
       1. A regex must first be compiled as an instance of Pattern class
    2. Regular expressions (a set of characters used to identify common in given strings)
       1. Character class, escape sequences, other constructs and quantifiers like *, ^, $, ., +
       2. To escape metacharacters, you would use a \, but you need to escape the \ too, so use \\metacharacter
       3. When you want to match one character in a sequence of characters, use [character_to_be_matched], with square brackets
       4. Pattern and Matcher classes
       5. Groups and backreferences
       6. https://www.regular-expressions.info/
       7. https://regexr.com/
    3. As == checks for reference equality, use .equals() for strings to check for value equality
    4. Iterate over strings
       1. https://stackoverflow.com/questions/3925130/java-how-to-get-iteratorcharacter-from-string
       2. StringCharacterIterator class
       3. StringReader class
       4. https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a?
          1. charAt() method
          2. toCharArray() method
       5. *Figure out later* - https://www.javaspecialists.eu/archive/Issue237.html, https://stackoverflow.com/questions/8894258/fastest-way-to-iterate-over-all-the-chars-in-a-string?answertab=votes#tab-top 
    5. compareTo() method
    6. split()
       1. Beware – it adds an empty string if the first element of the string proves to be a match for the regex parameter
       2. Either convert the characters matching the regex to whitespace and call the trim() method to remove trailing and leading whitespace,
       3. Or convert to ArrayList and use contains() and remove()
       4. Sorting strings
          1. Convert to charArray
          2. *Use Comparator interface* - https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/

15. Characters and Unicode
    1. To convert characters to Unicode code points
       1. Use CharSequence class's codePoints() method
       2. If you're using characters outside BMP - https://stackoverflow.com/questions/1527856/how-can-i-iterate-through-the-unicode-codepoints-of-a-java-string?answertab=votes#tab-top

16. Micro-optimisations
    1. For-each and for loops
       1. For arrays and Random Access objects like ArrayLists, use the traditional for loops
       2. Otherwise, for-each is more readable and efficient - https://stackoverflow.com/questions/1006395/fastest-way-to-iterate-an-array-in-java-loop-variable-vs-enhanced-for-statement, https://stackoverflow.com/a/12156099/13742805

17. Expressions and Statements
    1. https://docs.oracle.com/javase/specs/jls/se9/html/jls-15.html#jls-Expression
    2. https://docs.oracle.com/javase/specs/jls/se9/html/jls-14.html#jls-Statement

18. Reflection

    1. https://www.baeldung.com/java-reflection

    2. http://omtlab.com/java-reflection-tutorial/

    3. https://docs.oracle.com/javase/tutorial/reflect/

    4. ```java
       class MyPojo {
           public static void main(String[] args) {
               System.out.println(new MyPojo());
           }
       
           int i = 1;
           String s = "foo";
       
           @Override
           public String toString() {
               StringBuilder result = new StringBuilder();
               for (Field f: getClass().getDeclaredFields()) {
                   try {
                   result
                   .append(f.getName())
                   .append(" : ")
                   .append(f.get(this))
                   .append(System.getProperty("line.separator"));
                   }
                   catch (IllegalStateException ise) {
                       result
                       .append(f.getName())
                       .append(" : ")
                       .append("[cannot retrieve value]")
                       .append(System.getProperty("line.separator"));
                   }
                   // nope
                   catch (IllegalAccessException iae) {}
               }
               return result.toString();
           }
       }
       ```

    5. ```java
       public class Example{
       
         String activityState = "resume";
       
         public static void main(String[] args) {
       
              Example example = new Example();
              Class<?> c = example.getClass();
              Field field = c.getDeclaredField("activityState");
              System.out.println(field.getName());
              System.out.println(field.get(example));
         }    
       
       }
       ```

19. Comparable interface

    1. https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
    2. Implement this interface when you want to compare or sort objects

20. Iterable interface

    1. Implement this when you have a data structure and want to implement the for-each loop

### OO Concepts 

1. Inheritance (implicit and explicit superclass constructor call, overriding superclass methods – see Super keyword docs also); Abstract Classes; Interfaces (https://docs.oracle.com/javase/specs/jls/se14/html/jls-8.html#jls-8.2 for what constitute Class Members)
   1. Hybrid inheritance - https://beginnersbook.com/2013/10/hybrid-inheritance-java-program/
   2. Inheritance
      1. Use instanceof keyword to check for inheritance
      2. Upcasting, downcasting, polymorphism - https://www.baeldung.com/java-type-casting, https://stackoverflow.com/questions/14467999/cast-a-superclass-to-a-subclass, https://www.codejava.net/java-core/the-java-language/what-is-upcasting-and-downcasting-in-java
   3. Interfaces
      1. Purpose - Interfaces are public APIs to allow other classes to use that functionality. It allows objects from different packages to interoperate using the interface as a reference point
         1. To avoid this public functionality, use an abstract class, instead of an interface, or
         2. Create an abstract class that has a subclass with protected access that implements the methods
      2. Interface variables are public static final
         1. Therefore, implementing methods must also be public
         2. *Why*? https://stackoverflow.com/questions/9614708/why-should-we-declare-interface-methods-as-public, https://stackoverflow.com/questions/5376970/protected-in-interfaces, https://www.quora.com/Why-are-Java-interface-methods-by-default-public
      3. Interfaces can declare default, static and abstract methods (to override the default method, see https://www.tutorialspoint.com/is-it-mandatory-to-override-the-default-methods-of-an-interface-in-java) - https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.2
      4. Interfaces can act as variable reference types, so objects can be assigned to variables of type interface - https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html
         1. Discussion on whether it is best to code to an interface or an implementation - https://chat.stackoverflow.com/rooms/186603/discussion-on-answer-by-bill-the-lizard-what-does-it-mean-to-program-to-an-inte
         2. Implications
            1. Based on polymorphism, you have multiple inheritance of type – the ability of a class to implement more than one interface. An object can have multiple types: the type of its own class and the types of all the interfaces that the class implements. This means that if a variable is declared to be the type of an interface, then its value can reference any object that is instantiated from any class that implements the interface.
               1. https://stackoverflow.com/questions/7275844/interface-as-a-type-in-java
               2. https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html
            2. If the implementing class implementingClass has additional methods not defined in the interface which you want to access, but the instantiated object is of reference type interface, you will be unable to access those additional methods unless you one of the following:
               1. Add the methods to the interface used
               2. Create a new interface that has the additional methods and the first interface's methods
               3. Instantiate the object implementingClass itself as type ImplementingClass instead of as type interface
                  1. Instantiate at the start, or
                  2. If you need the type to remain as interface, convert to implementingClass type inside a method – for example, when converting HashMap to TreeMap, you can give as input the HashMap object to the new TreeMap object - https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/ 
               4. **(Not recommended)** Cast the object to type implementingClass
            3. *Couldn't figure this out* -https://stackoverflow.com/questions/42893291/declare-a-member-variable-of-both-a-class-and-interface-in-java, https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
   4. Variable hiding occurs when superclass and subclass have the same variables; any calls made to the variable point to the subclass variable
      1. To access superclass variable, use super.variableName, or
      2. Cast subclass to superclass type
         1. System.out.println(((Superclass) subclass.variableName);
         2. If object is of type superclass, but object instance is of subclass, subclass can access subclass' variable by doing ((Subclass) superclass).variableName as in such a scenario calling variableName is equivalent to the superclass.variableName
            1. Instance variable is chosen from the type of the object
         3. To avoid this situation, set variable as private in superclass, and use getters and setters to access and modify the variable
   5. Methods in subclasses
      1. For non-static methods with the same name, superclass method will be overriden unless the object is of type superclass – then superclass method will be called
      2. Static method hiding
         1. If a static method with the same name is declared in a subclass, the superclass method is hidden, not overriden – again, if the object is of type superclass, superclass method will be called
         2. Final methods cannot be overriden or hidden
   6. Abstract Classes vs Interfaces
      1. https://stackoverflow.com/questions/18777989/how-should-i-have-explained-the-difference-between-an-interface-and-an-abstract/22025689#22025689
      2. https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
         1. Abstract classes can implement interfaces, however it does not need to implement all the interface's methods
         2. You can use static members of the class as you would with any other class
      3. https://stackoverflow.com/questions/761194/interface-vs-abstract-class-general-oo/33963650#33963650
2. Encapsulation
   1. Use Setters and/or Getter with private fields to hide data
3. Abstraction
4. Polymorphism
   1. An object that is an instance of more than one class is polymorphic 