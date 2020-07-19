//Aim here to is find the retards with gmail accounts after they have been inputted

//One way of doing includes creating an Email class object which has the name and email fields as Strings, then adding a person's name and email as an Email object to an ArrayList, then checking for the gmail accounts

//Best way is to cut short all this nonsense and to check for the gmail account at the time of input by doing:

String[] email = in.next().split("@");
if(email[1].equals("gmail.com")){
    nameList.add(name);
    }

//then printing nameList

//Other possible Regex: ".+@gmail\\.com$"

//Your regex should have include \\.com$ as . is a metacharacter!

//My way of doing with TreeMap - TreeMap must have unqiue keys, so I put the names as TreeMap values, so duplicate names can still be entered

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
            
            tit.put(firstNameEmailID[1], firstNameEmailID[0]);    
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
