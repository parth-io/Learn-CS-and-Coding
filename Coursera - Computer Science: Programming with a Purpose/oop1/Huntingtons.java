public class Huntingtons {

    /* Performance requirement. The maxRepeats() and removeWhitespace() methods must take time
linear in the length of the string. */

    public static int maxRepeats(String dna) {
        int count = 0;
        String comparor = "C";
        int dnaLength = dna.length();
        int i = 0;
        while (i < (dnaLength - 2)) {
            if ((dna.charAt(i) - comparor.charAt(0)) == 0) {
                int temp = 0;
                boolean matchFound = false;
                while ((!matchFound) && (i < (dnaLength - 2))) {
                    String compareThis = dna.substring(i, (i + 3));
                    if (compareThis.equals("CAG")) {
                        temp += 1;
                        i += 3;
                        if (i >= dnaLength) {
                            break;
                        }
                    }
                    else {
                        matchFound = true;
                        i++;
                    }
                }
                if (count < temp) {
                    count = temp;
                }
            }
            else {
                i++;
            }
        }
        return count;
    }
    
    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String removedWhitespace = s.replace(" ", "");
        String removedWhitespace2 = removedWhitespace.replace("\n", "");
        String removedWhitespace3 = removedWhitespace2.replace("\t", "");
        // Must I have separate lines for \n and \t? Is there a better way to do it?
        return removedWhitespace3;
        /*
        Do not implement removeWhitespace() by creating a new string and concatenating together all of the non-whitespace characters: repeatedly concatenating n characters (one at a time) to a String object takes time proportional to n2 . You may do so using the StringBuilder  data type (a mutable version of the String data type): repeatedly appending n characters (one at a time) to a StringBuilder object takes time proportional to n.
        */
    }
    
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) {
            return "not human";
        }
        if (maxRepeats <= 35) {
            return "normal";
        }
        if (maxRepeats <= 39) {
            return "high risk";
        }
        if (maxRepeats <= 180) {
            return "Huntington’s";
        }
        else return "not human";
    }
    
    public static void main(String[] args) {
        String file = args[0];
        In in = new In(file);
        /*
        If the API did not specify that we had to input and return a String from the various methods, we could have used the following code to create an array of Strings without whitespace.
        private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;
        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length-1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
        */
        String input = in.readAll();
        String s = removeWhitespace(input);
        int maxRepeats = maxRepeats(s);
        String diagnosis = diagnose(maxRepeats);
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnosis);
    }
}
/*
~/Desktop/oop1> cat repeats4.txt
TTTTTTTTTT TTTTTTTTTT TTTTTTTTCAGCAGCAGCAG TTTCAGCAGT TTTTTTTTTT
TTTTTTTTTT TTTTTTTTTT TTTTTTTTTTTTTCAGTTTT TTTTTTTTTT T
~/Desktop/oop1> java-introcs Huntingtons repeats4.txt
max repeats = 4
not human
~/Desktop/oop1> cat repeats64.txt
TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTCAGCAGCA
GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA GCAGCAGCAG CAGCAGCAGC AGCAGCAGCA
GCAGTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT TTTTTTTTTT
~/Desktop/oop1> java-introcs Huntingtons repeats64.txt
max repeats = 64
Huntington's
~/Desktop/oop1> java-introcs Huntingtons chromosome4-hd.txt
max repeats = 79
Huntington's
~/Desktop/oop1> java-introcs Huntingtons chromosome4-healthy.txt
max repeats = 19
no Huntington's
*/
/*
To download the txt file, put the following code in the main method.
try (InputStream in = new URL("https://coursera.cs.princeton.edu/introcs/assignments/oop1/files/chromosome4-hd.txt").openStream()) {
            Files.copy(in, Paths.get("/home/..path_to_your_file/hd.txt"), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e) {
        }
try (InputStream in = new URL("https://coursera.cs.princeton.edu/introcs/assignments/oop1/files/chromosome4-healthy.txt").openStream()) {
            Files.copy(in, Paths.get("/home/..path_to_your_file/healthy.txt"), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e) {
        }
        
*/
