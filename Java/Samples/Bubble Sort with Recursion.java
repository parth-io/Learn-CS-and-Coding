//Recursion!!
public static int checkAndSwap(int a_i, int[] a){
        if(a_i >= 0 && a_i+1 < a.length){
            int nextInt = a[a_i+1];
            if(a[a_i] > nextInt){
                a[a_i+1] = a[a_i];
                a[a_i] = nextInt;
                return 1+checkAndSwap(a_i-1, a);
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int swaps = 0;
        for(int a_i=0; a_i < n; a_i++){
            swaps += checkAndSwap(a_i,a);
        }
        
        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }

//My way
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BubbleSort {
    int numSwaps;
    int[] a;
    int n;
    int totalPasses;
    int temp;
    
    BubbleSort (int[] a, int n){
    this.a = a;
    this.n = n;
    totalPasses = 0;}
    
    public void sort(){

for (int i = 0; i < n; i++) {
    numSwaps = 0;
    
    for (int j = 0; j < n - 1; j++) {
        if (a[j] > a[j + 1]) {
            temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
            numSwaps++;
            totalPasses++;
        }
    }
    
    if (numSwaps == 0) {
        break;
    }
}
int firstElement = a[0];
int lastElement = a[n - 1];
System.out.println("Array is sorted in " + totalPasses + " swaps.\nFirst Element: " + firstElement + "\nLast Element: " + lastElement);}
}

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        BubbleSort bS = new BubbleSort(a, n);
        bS.sort();
    }
}

