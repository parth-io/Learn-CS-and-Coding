public class MaximumSquareSubmatrix {

        private static int check(int[][] a, int i, int j, int count) {
        int temp = count;
        if ((i - count) < 0 || (j - count) < 0) { // If index is outside of the bounds of the arrays, there is no point in continuing with the search
            return temp;
        }
        for (int x = (i - count); x <= i; x++) {
            if (a[x][(j - count)] == 0) {
                    return temp;
            }
        }
        for (int x = (j - count); x <= j; x++) {
            if (a[(i - count)][x] == 0) {
                    return temp;
            }
        }
        temp++;
        temp = check(a, i, j, temp);
        return temp;
    }

    public static int size(int[][] a) { // It makes sense to start size() from the bottom-right of the arrray since (count-1) must be < than i or j, so we can add that improvement in
        int count = 0;
        for (int i = (a.length-1); i >= 0; i--) {
            for (int j = (a.length-1); j >= 0; j--) {
                if ((count-1) >= i || (count-1) >= j) {
                        break;
                    }
                if (a[i][j] == 1) {
                    int temp = 0;
                    temp += check(a, i, j, 1);
                    if (count < temp) {
                        count = temp;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(a));
    }
}
/*
Hint: Use dynamic programming. Specifically, for each row i and column j, compute the size of the largest contiguous square submatrix whose lower right endpoint is (i, j). What are the base cases? How can you compute this quantity for row i and column j if you know it for smaller values of i and j?

The size() method should take time proportional to n^2.

My second try at check()

        for (int x = (i - count); x <= i; x++) {
            for (int y = (j - count); y <= j; y++) {
                if (a[x][y] == 0) {
                    return temp;
                }
            }
        }

My first try at check() is below. If the bottom-right corner was 1, then my goal was to check if the other 3 array locations that would form a square of length 2 also contain the value 1. This approach failed because of my inability to devise a suitable method to update the value of count appropriately when the function check() is called recursively
    private static int check(int[][] a, int i, int j) {
        int count = 0;
        if ((i -1) < 0 || (j - 1) < 0) {
            return 0;
        }
        if (a[(i-1)][j] == 1) {
            count++;
            count += check(a, (i-1), j);
        }
        if (a[i][(j-1)] == 1) {
            count++;
            count += check(a, i, (j-1));
        }
        if (a[(i-1)][(j-1)] == 1) {
            count++;
            count += check(a, (i-1), (j-1));
        }
        if (count % 3 == 0) {
            //System.out.println("Checking for (" + i + ", " + j + ") with result " + count/3);
            return count/3;
        }
        //System.out.println("Checking for (" + i + ", " + j + ") with result 0");
        return 0;
    }

If you want to use the Scanner class to get input:
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        System.out.println(size(a));
        scan.close();
*/
