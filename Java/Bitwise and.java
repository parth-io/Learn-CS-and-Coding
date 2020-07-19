//Given a set of positive integers from 1 till n and an integer k, find two integers such that the result of the & operation performed on them is max and less than k. Constraint - n <= k.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.*;
import java.util.concurrent.*;

//My try

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            int max = 0;
            for (int i = 1; i < n; i++) {
                int j = i + 1;
                while (j <= n) {
                    int tmp = j & i;
                    //System.out.println(i + " " + j);
                    j++;
                    if (tmp < k && tmp > max) {
                            max = tmp;
                    }
                }
            }
            
            System.out.println(max);
        }

        scanner.close();
    }
}

//Mindblowing try #1 in Python

T = int(input().strip())
for _ in range(T):
    n , k = map(int , input().split())
    print(k-1 if ((k-1) | k) <= n else k-2)
    
/*Explanation:

Max value for the result is (k - 1) as the limit is k
We aim to get (k - 1) from any combination of numbers from the set of positive integers until n
By deduction, to get (k - 1), there are 2 cases
If you cannot get (k - 1) as the answer, (k - 2) is the next best answer

Case 1: 
k is odd with least signifcant bit 1, (k - 1) is even with least significant bit 0
Then, k - 1 & k = k - 1 as looking at the least significant bits for both numbers, 0 & 1 = 0 which is the least significant bit for the answer (k - 1)
(k - 1) | k = k, (k - 1) | k <= n is always true therefore there are no issues with whether k > n

Case 2:
k is even, (k - 1) is odd
To get (k - 1) as the answer, we need to do (k - 1) & ((k - 1) + 2^x) where x is an integer starting from 1 and 2^x is in base 10 which we need to convert to base 2
That is to say, possible pairs of values include (k - 1) & ((k - 1) + 2), (k - 1) & ((k - 1) + 4), (k - 1) & ((k - 1) & 8), and so on for 16, 32, ...
Such pairs will give (k - 1) as the least significant digit for ((k - 1) + 2^x) is 1
But we do not know if ((k - 1) + 2^x) <= n
Honestly, (k - 1) & ((k - 1) + 2) ought to work.
So we only need to check for (k + 1)
How to get (k + 1)? By doing (k - 1) | k = (k + 1)
If (k + 1) <= n is true, then (k - 1) & (k + 1) = (k - 1)
If it is not true, then there is no way of getting a number even larger than (k + 1) that is also <= n, so make do with (k - 2) --> (k - 1) & (k - 2) = (k - 2), (k - 2) is the answer

We can combine both cases in our logic, as both cases can test the same condition (k - 1) | k. If this condition is true, then the answer is (k - 1), if not, then (k - 2)
    
https://www.hackerrank.com/challenges/30-bitwise-and/forum <-- numerous comments here that explain the above logic
*/
//The code below adds on to the code above for cases where k > n

for _ in range(int(input())):
    n, k = map(int, input().split())
    print(
        (k-1 if (k-1)|k <= n else k-2)
        if k <= n
        else (n-1) & -2
    )

//In Java 
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            if(((k-1)|k) > n && k%2==0){
                System.out.println(k-2);
            }else{
                System.out.println(k-1);               
            }
        }

//Mindblowing try #2 in Python

for _ in xrange(int(raw_input())):
    n, k = map(int, raw_input().split())
    a = k - 1
//Tilde flips all the bits
    b = ~a & -~a
    if a | b > n:
        print a - 1
    else:
        print a
