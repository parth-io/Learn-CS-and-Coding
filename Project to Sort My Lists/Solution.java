import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.lang.reflect.Method;
import java.time.*;
import java.util.regex.*;
import java.security.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//The program looks for EOF in the last line of your list of words, so you must add the string EOF to the file
public class Solution {

    static Pattern p_Trailing = Pattern.compile("^(\\r\\n|[ \\t\\x0B\\f\\n\\r\\u2028\\u2029\\u0085])+|(\\r\\n|[ \\t\\x0B\\f\\n\\r\\u2028\\u2029\\u0085])+$");

    //Removes trailing whitespace and stuff
    public static String remove_Trailing(String s) {
        Matcher m = p_Trailing.matcher(s);
        return m.replaceAll("");
    }
    
    //Prints items from a set
    //Why 131072? It is a multiple of 512, the disk sector size for my HDD and is 128K
    public static void printer(Set<String> set, String filename) throws IOException {
        String name = filename + ".txt";
        BufferedWriter print = new BufferedWriter(new FileWriter(name), 131072);
        for(String d : set) {
            print.write(d + "\n");
        }
        print.flush();
        print.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in), 131072);
        
        Set<String> phrases = new HashSet<String>();
        
        TreeSet<String> words = new TreeSet<String>();
        
        String s = scan.readLine();
        
        Pattern p = Pattern.compile(". .", Pattern.MULTILINE);
        
        Pattern p_Corner_Case = Pattern.compile("\\w$");
        
        while(!(s.equals("EOF"))) {
            s = remove_Trailing(s);
            Matcher m = p.matcher(s);
            if(m.find()) {
                phrases.add(s);
            }
            else {
                Matcher m_Corner_Case = p_Corner_Case.matcher(s);
                if (m_Corner_Case.find()) {
                    words.add(s);
                }
                else {
                    phrases.add(s);
                }
            }
            s = scan.readLine();
        }
        
        scan.close();
        
        printer(words, "words");
        
        printer(phrases, "phrases");
    }
}
