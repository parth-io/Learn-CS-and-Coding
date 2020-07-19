//Method 1
import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
    int[] div;
    int mid;
    public int divisorSum(int n) {
        if (n == 1) {
            return 1;
        } else {
        mid = n / 2;
        div = new int[mid + 2];
        div[0] = 1;
        div[mid + 1] = n;
        for (int i = 2; i <= mid; i++){
            if (n % i == 0) {
                div [i] = i;
            }
        }
        return Arrays.stream(div).sum();
    }}
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}


//Method 2

class Calculator implements AdvancedArithmetic{
    public int divisorSum(int n){
        // n has no divisors other than itself
        if(n == 1){
            return n;
        }
        
        // Find and sum divisors:
        int half = n/2;
        int sum = n;
        do{
            if(n % half == 0){
                sum += half;
            }
        }while( half-- > 1 );
        
        return sum;
    }
}

//Method 3
public int divisorSum(int n) {
    int sum = 0;
    int sqrt = (int) Math.sqrt(n);

    // Small optimization: if n is odd, we can't have even numbers as divisors
    int stepSize = (n % 2 == 1) ? 2 : 1;

    for (int i = 1; i <= sqrt; i += stepSize) {
        if (n % i == 0) { // if "i" is a divisor
            sum += i + n/i; // add both divisors
        }
    }

    // If sqrt is a divisor, we should only count it once
    if (sqrt * sqrt == n) {
        sum -= sqrt;
    }
    return sum;
}

//Method 4 - sneakiest way to use square root!
class Calculator implements AdvancedArithmetic{
    public int divisorSum(int n){
        int sum = 0;
        for (int i = 1; i*i<=n; i++) {
            if (n % i == 0) {
                if (i != n / i) sum += i;
                
                sum += (n / i);

            }
        }
        return sum;
    }
}
