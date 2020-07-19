/*


More specifically, given the binary representation of an integer x
of length n, your task is to find another binary number y of length n with at most k set bits such that their bitwise XOR is maximum.

For example, let's say that x= "0100" and k = 1. The maximum possible XOR can be obtained with y = "1000", where x XOR y = "1100".


The first line of input contains the number of tests.

The first line of each test contains a binary string representing x.

The second line of each test contains an integer, k, denoting the maximum number of set bits in .

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String maxXorValue(String x, int k) {
        int lengT = x.length();
        char[] inputt = x.toCharArray();
        int[] input = new int[lengT];
        for (int i = 0; i < lengT; i++) {
            input[i] = inputt[i] - '0';
        }
        int[] output = new int[lengT];
        int count = 0;
        for (int j = 0; j < lengT; j++) {
            if (input[j] == 1) {
                    output[j] = 0;
                }
            if (count < k) {
                if (input[j] == 0) {
                    output[j] = 1;
                    count++;
                }
            }
        }
		String strArray[] = new String[output.length];
		for (int i = 0; i < output.length; i++) {
			strArray[i] = String.valueOf(output[i]); 
        }
        StringBuilder sb = new StringBuilder(output.length);
		for (String s : strArray) {
            sb.append(s);
		}
        return sb.substring(0);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                String y = Result.maxXorValue(s, k);
                System.out.println(y);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
    }
}
