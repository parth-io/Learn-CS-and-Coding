//What a meme

//My try

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        char[] cc = A.toCharArray();
        int aa = A.length();
        Outerloop:
        if ((aa & 0) == 1) {
            for (int i = 0; i < (aa/2) - 1; i++) {
                if (cc[i] != cc[aa - 1 - i]) {
                    System.out.println("No");
                    break Outerloop;
                }
            }
                    System.out.println("Yes");    
        }
        else {
            for (int i = 0; i < (aa -1)/2; i++) {
                if (cc[i] != cc[aa - 1 - i]) {
                    System.out.println("No");
                    break Outerloop;
                }
            }
                    System.out.println("Yes");    
        }    
    }
}

//Lol the remainder gets truncated in integer division, so...

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        char[] cc = A.toCharArray();
        int aa = A.length();
        Outerloop:
        if ((aa & 0) == 1) {
            for (int i = 0; i < (aa/2) - 1; i++) {
                if (cc[i] != cc[aa - 1 - i]) {
                    System.out.println("No");
                    break Outerloop;
                }
            }
                    System.out.println("Yes");    
        }
    }
}

//But, better still.......
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String R = new StringBuilder(A).reverse().toString();
        
        if(A.equals(R)) System.out.println("Yes");
        else System.out.println("No");
    }
}
