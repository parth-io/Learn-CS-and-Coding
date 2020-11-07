//Program to find out if two strings are anagrams from the Discussions page of the Anagrams challenge for Java - the editorial for the Java HackerRank challenge has more solutions, one of which is exactly like mine
//Why this solution is notable is because of the HashSet it uses, and the fact that it is O(n), whereas sorting arrays is n log(n) - https://www.hackerrank.com/challenges/java-anagrams/forum/comments/158850

static boolean isAnagram(String a, String b) {

// test for invalid input   
if( a == null || b == null || a.equals("") || b.equals("") )
    throw new IllegalArgumentException();

// initial quick test for non-anagrams
if ( a.length() != b.length() )
    return false;

a = a.toLowerCase();
b = b.toLowerCase();

// populate a map with letters and frequencies of String b
Map<Character, Integer> map = new HashMap<>();

for (int k = 0; k < b.length(); k++){
     char letter = b.charAt(k);    

    if( ! map.containsKey(letter)){
        map.put( letter, 1 );
    } else {
        Integer frequency = map.get( letter );
        map.put( letter, ++frequency );
    }
}

// test each letter in String a against data in the map
// return if letter is absent in the map or its  frequency is 0
// otherwise decrease the frequency by 1

for (int k = 0; k < a.length(); k++){
    char letter = a.charAt(k);

    if( ! map.containsKey( letter ) )
        return false;

    Integer frequency = map.get( letter );

     if( frequency == 0 )
        return false;
    else    
        map.put( letter, --frequency);
}
// if the code got that far it is an anagram
return true; 
