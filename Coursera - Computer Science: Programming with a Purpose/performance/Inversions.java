public class Inversions {

    public static long count(int[] a) {
        long count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < j) && (a[i] > a[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /*
    Your original method is inefficient. A faster way to do it upon reflection is by checking if k < (n-1). If yes, then depending on the diff, go calculate the diff and slot the value of (n-1) at the appropriate location while the rest of the numbers are filled in in ascending order from the left. Or what you could do is put (n-1) last in the permutation (at the rightmost index of the array). If no, (n-1) goes at the zeroth index or the start of the array. Then check if k - (n-1) < (n - 2). Rinse and repeat.
    
    
    Basically what I am doing is firstly finding the value of n, x, for which k < (x+1)*((x+1)-1)/2. n(n-1)/2 = 0 + 1 + 2 + ... + (n-1) + n.
    Once found, calculate the difference diff. diff = (x+1)*((x+1)-1)/2 - k
    The first for loop enters the largest values first at the right of the array.
    Depending on the value of diff, we enter the value of (+1) first at the relevant location. diff + x*(x+1)/2 = k.
    Then, we fill in the remaining values, starting from x till 0, at the empty locations in the array, in ascending order.
    */
    public static int[] generate(int n, long k) {
        int[] perm = new int[n];
        long sum = 0;
        int x = 0;
        int diff = 0;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                perm[i] = i;
            }
            return perm;
        }
        else {
            for (int i = 0; i < n; i++) {
                sum += i;
                if (k <= sum) {
                    x = (i-1);
                    diff = (int) (sum - k);
                    break;
                }
            }
            for (int i = (x+2); i < n; i++) {
                perm[i] = i;
            }
            int y = x;
            perm[diff] = (x+1);
            for (int i = 0; i <= (x+1); i++) {
                if (perm[i] == 0) {
                    perm[i] = y;
                    y--;
                }
            }
        }
        return perm;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] perm = generate(n, k);
        for (int i : perm) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/*
Note: There is no linear-time algorithm for counting the number of inversions in an array (or permutation) of length n. However, there is an nlogn algorithm that uses the same divide-and-conquer technique as used in sorting algorithms and mergesort. 

double start = System.currentTimeMillis();
double now = System.currentTimeMillis();
System.out.printf("(%.0f seconds)\n", (now - start));
*/
