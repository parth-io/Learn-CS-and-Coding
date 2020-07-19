/*
What is so special about this code? The various ways you can solve this challenge.

Aim - get a name and email id, print out the names of those with a @gmail.com email id.

What I did:
TreeMap<Key, Value>
Key is email id
Value is name
Why did I do the above instead of putting name as key?
If names are repeated, the TreeMap will still work as duplicate keys are not allowed.
However, there is no point to using TreeMap, as TreeMap will sort the pairs by the email ids.
Next, we need to sort the names
Use Collections.sort for the ArrayList of names

What could have been done?
Use HashMap and sort
Use ArrayList inside an ArrayList
*/





import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.*;
import java.util.concurrent.*;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TreeMap<String, String> tit = new TreeMap<String, String>();
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            
            tit.put(emailID, firstName);    
        }
        scanner.close();
        
        String myRegEx = "@gmail.com$";
        
        Pattern p = Pattern.compile(myRegEx);
        
        ArrayList<String> yoS = new ArrayList<String>();
        
        for (Map.Entry<String, String> m: tit.entrySet()) {
            Matcher ma = p.matcher(m.getKey());
            if (ma.find()) {
                yoS.add(m.getValue());
            }
        }
        Collections.sort(yoS);
        for (String x : yoS) {
        System.out.println(x);
        }
    }
}
