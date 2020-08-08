import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.time.*;
import java.util.regex.*;
import java.security.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static Pattern p_Trailing_Words = Pattern.compile("(\\r\\n|[ \\t\\x0B\\f\\n\\r\\u2028\\u2029\\u0085])+");
    
    static Pattern p_Trailing_Phrases = Pattern.compile("^(\\r\\n|[ \\t\\x0B\\f\\n\\r\\u2028\\u2029\\u0085])+|(\\r\\n|[ \\t\\x0B\\f\\n\\r\\u2028\\u2029\\u0085])+$");

    //Removes trailing whitespace and stuff
    public static String remove_Trailing(String s, Pattern p_Trailing) {
        Matcher m = p_Trailing.matcher(s);
        return m.replaceAll("");
    }
    
    //Prints items from a set
    public static void printer(Set<String> set) {
        for(String d : set) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        Set<String> phrases = new HashSet<String>();
        
        TreeSet<String> words = new TreeSet<String>();
        
        String s = scan.readLine();
        
        Pattern p = Pattern.compile(". .", Pattern.MULTILINE);
        
        while(!(s.equals("EOF"))) {
            Matcher m = p.matcher(s);
            if(m.find()) {
                phrases.add(remove_Trailing(s, p_Trailing_Phrases));
            }
            else {
                words.add(remove_Trailing(s, p_Trailing_Words));
            }
            s = scan.readLine();
        }
        
        scan.close();
        
        printer(words);
        
        printer(phrases);
    }
}
