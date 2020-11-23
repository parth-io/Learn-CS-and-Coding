import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    
    private final String name;
    private final int value;
    private final String category; 
    
    public Bar(String name, int value, String category) {
        if ((name == null) || (value < 0) || (category == null)) {
            throw new IllegalArgumentException("Arguments are not valid");
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public String getCategory() {
        return this.category;
    }

    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Argument is null");
        }
        return (this.value - that.value);
    }

    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        Arrays.sort(bars);
        
        for (Bar x : bars) {
            System.out.println(x.getName());
        }
    }
}
/*
To sort an array of objects, use Java’s Arrays.sort() method. How does Arrays.sort() know to call the compareTo() method that I defined? This mechanism is known as dynamic dispatch. Since Java knows the type of every object, when it is time to compare two objects of type Bar, Java calls the compareTo() method that you implemented in the class Bar. 

Comparable interface - In order to use a data type with Arrays.sort(), that data type must be comparable. This is Java’s mechanism for specifying a total order among objects of a given type. To make a data type comparable, you must implement the Comparable interface, which involves doing two things:

1. Add implements Comparable<Bar> to the class definition to indicate that Bar objects can be compared (by value).
2. Include a method compareTo() to specify how to compare two Bar objects. In this case, return a { negative integer, zero, positive integer } if value of the invoking object is { less than, equal to, greater than } the value of the argument object. 

If you leave out implements Comparable<Bar> in class declaration, it would lead to a compile-time error if you attempted to call Arrays.sort() with an array of Bar objects. The argument to Arrays.sort() must be an array of comparable objects; otherwise, Java cannot guarantee the existence of the compareTo() method at compile time. 

If you include implements Comparable<Bar> but don’t implement the compareTo() method, it would lead to a compile-time error. By including the code implements Comparable<Bar>, you are promising to implement a method named compareTo() with the specified signature. 

Corner cases - Handle invalid argument in the following manner:

1. Throw an IllegalArgumentException in the constructor if name is null, value is negative, or category is null.
2. Throw a NullPointerException if the argument to compareTo() is null. 
*/
