public class RevesPuzzle {

    private static void hanoi3(int n, int k, String from, String temp, String to) {
        if (n == k) {
            return;
        }
        hanoi3((n - 1), k, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi3((n - 1), k, temp, from, to);
    }
    
    private static void hanoi4(int n, String from, String temp1, String temp2, String to) {
        int k = n + 1 - (int) Math.round(Math.sqrt((2 * n) + 1));
        if (n <= 1) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }
        else {
            hanoi4(k, from, temp2, to, temp1);
            hanoi3(n, k, from, temp2, to);
            hanoi4(k, temp1, temp2, from, to);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //Since n > 0, k > 0 - prove it yourself!
        hanoi4(n, "A", "B", "C", "D");
    }
}

//My pathetic first try is below:
/*
public class RevesPuzzle {

    private static void hanoi3(int n, int end, String starting, String temp, String ending) {
        if (n == (end)) {
            //System.out.println("Returning from hanoi3");
            return;
        }
        //System.out.println("Before starting 1st recursive hanoi3");
        hanoi3(n-1, end, starting, ending, temp);
        System.out.println("Move disc " + n + " from " + starting + " to " + ending);
        //System.out.println("Before starting 2nd recursive hanoi3");
        hanoi3(n-1, end, temp, starting, ending);
    }
    
    private static void hanoi4(int n, String starting4, String temp14, String temp24, String ending4) {
        int k = n + 1 - (int) Math.round(Math.sqrt((2 * n) + 1));
        //System.out.println("k calculated, " + k);
        if (k <= 0) {
            return;
            //hanoi3(n, 0, temp14, temp24, ending4);
            //System.out.println("k <= 0");
        }
        else {
            //System.out.println("Shifting k discs to temp pole");
            hanoi3(k, 0, starting4, temp24, temp14);
            //System.out.println("Shift n - k discs");
            //System.out.println(n + " " + (n - k));
            hanoi3(n, (n - k - 1), temp14, temp24, ending4);
            //System.out.println("Shift k back");
            hanoi4(k, temp14, temp24, starting4, ending4);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi4(n, "A", "B", "C", "D");
    }
}*/
