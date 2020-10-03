Only useful links are here, the rest of the stuff is in the Java docs at https://docs.oracle.com/javase/tutorial/, https://docs.oracle.com/javase/8/docs/api/index.html and https://docs.oracle.com/javase/8/docs/.  

https://en.wikipedia.org/wiki/Liskov_substitution_principle 

https://www.journaldev.com/37273/java-14-features 

JUnit testing framework 

Cracking the Coding Interview: 150 Programming Questions and Solutions book 

https://www.java2novice.com/java_interview_questions/ 

Google's Gauva 

Apacha Common Lang/Utils 

https://marcus-biel.com/ 

https://www3.ntu.edu.sg/home/ehchua/programming/ 

 

# Java's Basics, Semantics, Syntax 

Data Types, Arrays - https://www.hackerrank.com/challenges/30-arrays/tutorial, https://www.javatpoint.com/java-data-types 

Characters - https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html 

Class, Variable, Function, Method, Object, Stream, Fields, Constructors - https://www.hackerrank.com/challenges/30-hello-world/tutorial 

Instances of Java classes are objects 

Self-referential classes 

https://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/linkedlists/index.html 

Instance variables, local variables and class variables 

Instance variables have object-level scope, being defined in a class; local variables have a block-level scope, being defined in a method or loop; class (static) variables have a class-level scope. 

Therefore, you cannot access local variables from outside the method, you must declare them outside the method 

Local variables are not initialised to any default values unlike class or instance variables 

https://stackoverflow.com/questions/415687/why-are-local-variables-not-initialized-in-java 

https://stackoverflow.com/questions/268814/uninitialized-variables-and-members-in-java 

https://stackoverflow.com/questions/1542824/initialization-of-instance-fields-vs-local-variables 

https://stackoverflow.com/questions/22811261/why-local-variable-must-be-initialized-and-why-instance-variables-must-not-be-in 

https://softwareengineering.stackexchange.com/questions/361502/why-doesnt-java-automatically-initialize-local-variables-with-its-default-value 

Local variables shadow instance variables, to access instance variable, use this.instanceVariable 

Constructor parameters can shadow instance variables 

Neither can you have static fields inside a method, nor can you have a static field in an inner class (for why, see https://stackoverflow.com/questions/1953530/why-does-java-prohibit-static-fields-in-inner-classes) 

Static methods and variables 

You cannot access non-static members of a class from a static context 

Static fields and methods are not thread-safe 

Did not understand 

Initialization is an important aspect of a static block. Static fields or variables are initialized after the class is loaded into memory. The order of initialization is from top to bottom, in the same order in which they are declared in the source file of the Java class. Since static fields are initialized in a thread-safe manner, this process is also used to implement the Singleton pattern. If you are not using an Enum as a Singleton for some reason, then you have a good alternative. But in this case, you must take into account that this is not a "lazy" initialization. This means that the static field will be initialized even BEFORE someone "asks" for it. If an object is resource-heavy or rarely used, then initializing it in a static block won't work in your favor. 

https://www.geeksforgeeks.org/singleton-class-java/, https://en.wikipedia.org/wiki/Singleton_pattern 

singleton class vs enum 

Singleton classes, singleton classes using enum 

DayOfWeek class' Enum constants are singleton instances – what does this mean 

What does this mean - During serialization, static fields, like transient variables, are not serialized. Indeed, if you save any data in a static field, it will contain its initial (default) value after deserialization. For example, if a static field is an int, its value will be zero after deserialization. If its type is float, the value will be 0.0. If the field is an Object, the value will be null. To be honest, this is one of the most frequently asked questions about serialization in interviews for Java positions. Don't store essential object data in a static field! 

Method parameters are pass-by-value - https://dzone.com/articles/java-pass-by-reference-or-pass-by-value, http://www.javadude.com/articles/passbyvalue.htm, https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value?rq=1, https://stackoverflow.com/questions/373419/whats-the-difference-between-passing-by-reference-vs-passing-by-value#comment102368162_430958 

Copies of primitive variables are passed 

Copies of object variables are passed also, but as the value of an object is its reference, the same object is passed 

Except in the case of strings which are immutable, treat strings as primitives or use StringBuilder 

Initialising fields 

Traditional way - declaring and initialising fields in one-line at the start of the class body 

Alternatives 

To initialise instance members 

Initialiser blocks 

They initialise instance members after an instance is created and before the constructor is called 

Therefore, useful in sharing a common block of code across constructors 

Final methods 

Static initalisation blocks 

For complex initialisation, like try-catch block or conditionals 

Initialised before any objects of the class are created 

Did not understand - https://stackoverflow.com/questions/4694661/declaring-java-object-given-its-type-class-name-as-string 

Access Modifiers and Annotations (javadocs - https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#format, https://docs.oracle.com/javase/7/docs/technotes/tools/solaris/javadoc.html#leadingasterisks) 

Operators - https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html 

Boolean and ternary (ternary operator ? can replace if-else statements https://stackoverflow.com/questions/4192225/prettiness-of-ternary-operator-vs-if-statement, https://www.programiz.com/java-programming/ternary-operator) 

Bitwise and Conditional Operators 

Bitwise operators have integer, byte, long, etc. Operands 

Can be used to check for odd/even numbers 

Can be used as logical operators also, but not recommended 

Conditional operators are logical operators and have boolean operands, but they follow short-circuit evaluation 

Operator precedence – bitwise operator & is lower than == 

~ 

Performs a bitwise NOT operator thtat flips the bits of the number 

If the number system is using two's complement, the effect is of negating a positive number's sum with 1 

For, while and do-while statements 

Object Creation 

Declaration, Insstantiation and Initialisation 

https://stackoverflow.com/questions/2330767/what-is-the-difference-between-instantiated-and-initialized 

https://stackoverflow.com/questions/15074083/difference-between-initializing-a-class-and-instantiating-an-object 

https://stackoverflow.com/questions/32290879/meanings-of-declaring-instantiating-initializing-and-assigning-an-object 

 

Java Tips 

Java.lang.class (see https://www.geeksforgeeks.org/java-lang-class-class-java-set-1/ for ways to instanstiate an object of type Class; one way to use its methods is System.out.println(Arrays.toString(this.getClass().getMethod("test", null).getDeclaringClass().getInterfaces())); .getClass returns runtime class, while .getDeclaringClass returns class returns the class in which the object was declared) 

Double colon method reference operator - https://stackoverflow.com/questions/28023364/what-is-the-equivalent-lambda-expression-for-system-outprintln/28025717#28025717, https://stackoverflow.com/questions/31020269/what-is-the-use-of-system-outprintln-in-java-8, https://stackoverflow.com/questions/20599579/why-must-we-use-double-colons-for-method-references, https://www.baeldung.com/java-8-double-colon-operator, https://www.geeksforgeeks.org/double-colon-operator-in-java/ 

Lists and Arrays 

List interface – ArrayList vs LinkedList (https://www.javatpoint.com/difference-between-arraylist-and-linkedlist) 

ArrayList vs Array 

ArrayList's forEach() method 

(element) -> action 

ArrayList vs List 

ArrayList vs LinkedList 

https://javahungry.blogspot.com/2015/04/difference-between-arraylist-and-linkedlist-in-java-example.html 

To convert from a Collection that contains objects of type Foo to an array, do this: Foo[] foos = x.toArray(new Foo[x.size()]); 

https://www.geeksforgeeks.org/convert-an-arraylist-of-string-to-a-string-array-in-java/ 

Convert array to String 

Use StringBuilder append(char[] ) method 

Arrays.toString() 

ListIterator and Iterator interfaces 

listIterator() method 

Use StringBuilder class in Java to create mutable strings (stings in Java are immutable, therefore operations on strings can create high memory overload) 

for i : x – for each i in an array x 

To return multiple values from one method, you will need to need to put the values in one object (I.e. a class or list) - https://www.geeksforgeeks.org/returning-multiple-values-in-java/ 

Break and continue statements 

Use labels for nested loops - https://stackoverflow.com/questions/886955/how-do-i-break-out-of-nested-loops-in-java 

Switch statements 

Primitive types 

When doing division, be careful – if you use integer for division, any non-integer answer will be truncated to an integer, even if you are storing the result of the division to a float or double. Therefore, always use double number in number operations, or cast to double or float 

Don't cast the entire expression, but rather cast only the integer numerator or denominator or both to double. Otherwise, integer division will be performed, returning an integer result which is then casted to double.  

Implicit or explicit casting 

https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double/36471636#36471636 

Implicit casting (for upcasting) 

Write nothing extra, just declare a wider data type and initialise to the narrower data type's value 

Double x = y //where y is an int 

Double.valueOf() 

Double d = new Double(int) 

When doing math, multiply numerator or denominator by 1.0, or add 0.0 

Explicit (for downcasting) - (int) or Double.intValue()/longValue() or Math.round() or Number class' methods  

Beware of widening and narrowing conversions 

Convert int to byte is widening, how to do? - See bookmarks 

Why can convert float to long  when float is 32 bit – See Firefox bookmarks 

Use BigDecimal class for accuracy, or StrictMath class 

When constructing a BigDecimal object, always use a String instead of a primitive type for parameter – avoids issues with inexact values 

To round numbers/decimals 

Use BigDecimal class 

round() - when you want to get the number of significant digits 

setScale() - when you want to set the scale (number of digits to right of decimal point) - https://stackoverflow.com/questions/3843440/bigdecimal-setscale-and-round 

Use DecimalFormat 

Use Math.round() (not recommended) 

Multiply the decimal by 10^n to get a number that only has one decimal point, then round the new number, then divide by 10^n 

Why this fails – you are multiplying a floating point digit, the result of the multiplication might not be what you expect, especially for values at the boundary edge of .5 

External libraries 

Apache Commons Math – Precision.round() 

decimal4j – DoubleRounder.round 

All literal numbers are taken to be integers, so for long numbers you can add a L 

.MIN_VALUE and .MAX_VALUE 

Input/Output 

printf or format method to choose format for output 

See Formatter class 

For the flag '0', must enter width after the flag 

String.format("%1$" +  number_of_spaces + "s", inputString).replace(' ', '0'); 

Format 1st argument which is a string as right-justified and with spaces appended, then replace spaces with 0s 

System.out.printf("%-8d%-8d%-8.7g\n", x, y, fraction) 

To print a table of 2 integers and a double 

For numbers, you can still use the two methods above or use DecimalFormat 

Beware – the nextInt() method does not scan until the end of the line unlike nextLine() method 

Console, Reader class (implemented by BufferReader among others), and Scanner class 

For text data 

BufferReader is used for costly/long input operations 

It is a Decorater Pattern class 

To check for EOF in BufferedReader 

Either do while (null != (String_inputted = bufferedreader_object.readLine())) 

Or String s = r.readLine(); 
while (s != null) { 
    // do something;  s = r.readLine();] 

Scanner 

https://www.hackerrank.com/challenges/30-data-types/tutorial  

nextLine() proceeds to the end of the current line, so you may need to use nextLine() twice 

Instead of using scan.nextLine() twice, you can use a loop to concatenate when there is next line: for (scan.hasNextLine()) {	st += scan.nextLine(); } 

InputStream class is for reading bytes 

Wrap a FileInputStream in a InputStreamReader object if you are reading text with a different encoding, as FileReader uses the default platform encoding 

Output - https://howtodoinjava.com/java/io/java-write-to-file/#PrintWriter 

System.out 

Files.writeString() 

Files.write() 

BufferedWriter 

FileWriter 

PrintStream 

PrintWriter 

Formatted text 

FileOutputStream 

Binary data 

OutputStreamWriter 

DataOutputStream 

Primitive data types 

FileChannel 

Large files 

System.exit 

Strings and escape sequences 

Escape characters and UTF (unicode) values (signalled by a \) in strings from the input stream will be considered appropriately, however, the program will ignore any escape characters in text from files 

Either use Apache Commons Lang's StringEscapeUtils.unescapeJava() or, 

Take each \ separately, convert it to hexadecimal and then to a character 

https://stackoverflow.com/a/11145854/13742805 

Note on replaceAll() vs replace 

replaceAll takes a regular expression and not a string 

https://stackoverflow.com/a/1701876/13742805 

To escape an escape character, do the following: 

Use \\ 

char (92) will give you a \ 

Read text from a file 

Numbers, Currencies and Date and Time 

Date and Time 

Use the java.util.time.* libraries only 

Uses static factory methods and not constructors 

To convert an object to String, for example for DayOfWeek object of type enum 

Locale locale = Locale.getDefault(); and DayOfWeek_Object.getDisplayName(TextStyle.FULL, locale) 

DayOfWeek_Object.name() 

Enum class is parent class and it has an abstract method name() 

Currency 

NumberFormat's getCurrencyInstance(Locale locale) for currency format, then call the format() method 

You don't need to instantiate a NumberFormat object, just declare a variable of type NumberFormat and call the getInstance() method 

The getInstance method returns an object of type DecimalFormat, which is an implementing subclass of the abstract NumberFormat class 

Numbers 

DecimalFormat - https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html 

Because performance is important to graphics applications, and because it's faster to access an array element than to call a method, developers resort to performance tricks such as creating and initializing arrays of sines and cosines. 

Assertion 

 

Stepping Up 

Exceptions – throw can be used to throw any exception, checked or unchecked; throws must be put in the method declaration if the exception is checked and you want throw the exception up the method call stack (no catch statement); throws allows the compiler and program to know that the given exception(s) can occur in the method - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html 

Streams vs Loops - https://blog.overops.com/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/, https://www.baeldung.com/java-collection-stream-foreach, https://blog.jooq.org/2015/12/08/3-reasons-why-you-shouldnt-replace-your-for-loops-by-stream-foreach/, https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops, http://cr.openjdk.java.net/~briangoetz/lambda/lambda-libraries-final.html, https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html 

Convert int array to String array via Streams 

https://www.techiedelight.com/convert-int-array-string-array-java/ 

https://www.techiedelight.com/convert-int-array-string-array-java/ 

Threads 

This keyword - https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html 

Lambda expression vs Anonymous class 

Java collections - https://dzone.com/articles/an-introduction-to-the-java-collections-framework 

Maps interface 

Hash maps, Map interface, and Dictionary class 

https://www.geeksforgeeks.org/differences-treemap-hashmap-linkedhashmap-java/ 

Dictionary class is obsolete 

Hash map uses Map interface 

https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable 

https://stackoverflow.com/questions/1348199/what-is-the-difference-between-the-hashmap-and-map-objects-in-java 

Did not understand if/why HashMap must override equal() and hashCode() methods 

why must hashmap have equals and hashcode 

https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/ 

https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java 

https://www.programcreek.com/2011/07/java-equals-and-hashcode-contract/ 

hashCode() equals() hashmap 

Generics; Classes; Types 

Formats 

Declaring object - Map<String, Integer> object = new LinkedHashMap<String, Integer>(); 

Declaring variable – T variableName; 

Default constructor - <modifier> <T>ClassName() {} 

Method - <modifier> <T> type_of_returned_object methodName(T t) {} 

Using type witnesses when invoking methods – ClassName.<T>methodName(t) instead of ClassName.methodName(t) 

Bounded types 

Wildcards 

https://stackoverflow.com/questions/16707340/when-to-use-wildcards-in-java-generics, https://docs.oracle.com/javase/tutorial/extra/generics/methods.html 

Do not understand why we need unbounded wildcards - Unbounded wildcards 

Say we want to print elements of a list with method printList(List<Object> list) 

It only prints a list of Object instances; it cannot print List<String>, List<Integer>, etc. because they are not subtypes 

So we generic printList method, use List<?> 

But this works also - <T extends Object> printList(List<T> list) - it prints strings and integers 

So why do we need wildcards? We can still upper bounded type parameters 

It's important to note that List<Object> and List<?> are not the same. You can insert an Object, or any subtype of Object, into a List<Object>. But you can only insert null into a List<?>.  

Inheritance rules apply to generics 

They apply to the type arguments also 

An operation performed on a type argument, the class Number, is equally valid if performed on its subtypes, the classes Integer and Double, also 

Generic classes themselves can subtype 

ArrayList<T> is a subtype of List<T>, itself a subtype of Collection<T> 

https://stackoverflow.com/questions/2770321/what-is-a-raw-type-and-why-shouldnt-we-use-it 

Covariance and contravariance - https://dzone.com/articles/covariance-and-contravariance, https://stackoverflow.com/questions/2770264/what-is-the-difference-between-e-extends-number-and-number/, https://www.freecodecamp.org/news/understanding-java-generic-types-covariance-and-contravariance-88f4c19763d2/ 

Could not understand - https://stackoverflow.com/questions/2745193/why-is-using-collectionstring-class-illegal 

Variable-length arguments (varargs) 

Converting types - https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1  

Inner classes 

Inner classes can be static 

Non-static inner classes cannot have static fields or methods 

Inner methods alternatives 

https://www.geeksforgeeks.org/method-within-method-in-java/ 

Manipulating and searching strings 

Use String class methods – for example, String.split(String regex) 

A regex must first be compiled as an instance of Pattern class 

Regular expressions (a set of characters used to identify common in given strings) 

Character class, escape sequences, other constructs and quantifiers like *, ^, $, ., + 

To escape metacharacters, you would use a \, but you need to escape the \ too, so use \\metacharacter 

When you want to match one character in a sequence of characters, use [character_to_be_matched], with square brackets 

Pattern and Matcher classes 

Groups and backreferences 

https://www.regular-expressions.info/ 

https://regexr.com/ 

As == checks for reference equality, use .equals() for strings to check for logical(?) equality 

Iterate over strings 

https://stackoverflow.com/questions/3925130/java-how-to-get-iteratorcharacter-from-string? 

StringCharacterIterator class 

StringReader class 

https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a? 

charAt() method 

toCharArray() method 

Figure out later - https://www.javaspecialists.eu/archive/Issue237.html, https://stackoverflow.com/questions/8894258/fastest-way-to-iterate-over-all-the-chars-in-a-string?answertab=votes#tab-top 

compareTo() method 

split() 

Beware – it adds an empty string if the first element of the string proves to be a match for the regex parameter 

Either convert the characters matching the regex to whitespace and call the trim() method to remove trailing and leading whitespace, 

Or convert to ArrayList and use contains() and remove() 

Sorting strings 

Convert to charArray 

Use Comparator interface - https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/ 

Characters and Unicode 

To convert characters to Unicode code points 

Use CharSequence class's codePoints() method 

If you're using characters outside BMP - https://stackoverflow.com/questions/1527856/how-can-i-iterate-through-the-unicode-codepoints-of-a-java-string?answertab=votes#tab-top 

Micro-optimisations 

For-each and for loops 

For arrays and Random Access objects like ArrayLists, use the traditional for loops 

Otherwise, for-each is more readable and efficient - https://stackoverflow.com/questions/1006395/fastest-way-to-iterate-an-array-in-java-loop-variable-vs-enhanced-for-statement, https://stackoverflow.com/a/12156099/13742805 

Expressions and Statements 

https://docs.oracle.com/javase/specs/jls/se9/html/jls-15.html#jls-Expression 

https://docs.oracle.com/javase/specs/jls/se9/html/jls-14.html#jls-Statement 

Reflection 

https://www.baeldung.com/java-reflection  

  

OO Concepts 

Inheritance (implicit and explicit superclass constructor call, overriding superclass methods – see Super keyword docs also); Abstract Classes; Interfaces (https://docs.oracle.com/javase/specs/jls/se14/html/jls-8.html#jls-8.2 for what constitute Class Members) 

Hybrid inheritance - https://beginnersbook.com/2013/10/hybrid-inheritance-java-program/ 

Inheritance 

Use instanceof keyword to check for inheritance 

Upcasting, downcasting, polymorphism - https://www.baeldung.com/java-type-casting, https://stackoverflow.com/questions/14467999/cast-a-superclass-to-a-subclass, https://www.codejava.net/java-core/the-java-language/what-is-upcasting-and-downcasting-in-java 

Interfaces 

Purpose - Interfaces are public APIs to allow other classes to use that functionality. It allows objects from different packages to interoperate using the interface as a reference point 

To avoid this public functionality, use an abstract class, instead of an interface or, 

 Create an abstract class that has a subclass with protected access that implements the methods 

Interface variables are public static final 

Therefore, implementing methods must also be public 

Why? https://stackoverflow.com/questions/9614708/why-should-we-declare-interface-methods-as-public, https://stackoverflow.com/questions/5376970/protected-in-interfaces, https://www.quora.com/Why-are-Java-interface-methods-by-default-public 

Interfaces can declare default, static and abstract methods (to override the default method, see https://www.tutorialspoint.com/is-it-mandatory-to-override-the-default-methods-of-an-interface-in-java) - https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.2 

Interfaces can act as variable reference types, so objects can be assigned to variables of type interface - https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html 

Discussion on whether it is best to code to an interface or an implementation - https://chat.stackoverflow.com/rooms/186603/discussion-on-answer-by-bill-the-lizard-what-does-it-mean-to-program-to-an-inte 

Implications 

Based on polymorphism, you have multiple inheritance of type – the ability of a class to implement more than one interface. An object can have multiple types: the type of its own class and the types of all the interfaces that the class implements. This means that if a variable is declared to be the type of an interface, then its value can reference any object that is instantiated from any class that implements the interface. 

https://stackoverflow.com/questions/7275844/interface-as-a-type-in-java 

https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html 

If the implementing class implementingClass has additional methods not defined in the interface which you want to access, but the instantiated object is of reference type interface, you will be unable to access those additional methods unless you do the following 

Add the methods to the interface used 

Create a new interface that has the additional methods and the first interface's methods 

Instantiate the object implementingClass itself as type ImplementingClass instead of as type interface 

Instantiate at the start, or 

If you need the type to remain as interface, convert to implementingClass type inside a method – for example, when converting HashMap to TreeMap, you can give as input the HashMap object to the new TreeMap object - https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/ 

(Not recommended) Cast the object to type implementingClass 

Couldn't figure this out -https://stackoverflow.com/questions/42893291/declare-a-member-variable-of-both-a-class-and-interface-in-java, https://docs.oracle.com/javase/tutorial/java/generics/bounded.html 

Variable hiding occurs when superclass and subclass have the same variables; any calls made to the variable point to the subclass variable 

To access superclass variable, use super.variableName, or, 

Cast subclass to superclass type 

System.out.println(((Superclass) subclass.variableName); 

If object is of type superclass, but object instance is of subclass, subclass can access subclass' variable by doing ((Subclass) superclass).variableName as in such a scenario calling variableName is equivalent to the superclass.variableName 

Instance variable is chosen from the type of the object 

To avoid this situation, set variable as private in superclass, and use getters and setters to access and modify the variable 

Methods in subclasses 

For non-static methods with the same name, superclass method will be overriden unless the object is of type superclass – then superclass method will be called 

Static method hiding 

If a static method with the same name is declared in a subclass, the superclass method is hidden, not overriden – again, if the object is of type superclass, superclass method will be called 

Final methods cannot be overriden or hidden 

Abstract Classes vs Interfaces 

https://stackoverflow.com/questions/18777989/how-should-i-have-explained-the-difference-between-an-interface-and-an-abstract/22025689#22025689 

https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html 

Abstract classes can implement interfaces, however it does not need to implement all the interface's methods 

You can use static members of the class as you would with any other class 

https://stackoverflow.com/questions/761194/interface-vs-abstract-class-general-oo/33963650#33963650 

Encapsulation 

Use Setters and/or Getter with private fields to hide data 

Abstraction 

Polymorphism 

An object that is an instance of more than one class is polymorphic 