public class Checkerboard {

    public static void main(String[] args){
                int n = Integer.parseInt(args[0]);
                StdDraw.setXscale(0, n);
                StdDraw.setYscale(0, n);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if ((i + j) % 2 != 0) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        else                  StdDraw.setPenColor(StdDraw.BLUE);
                        StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                    }
                }
    }
}
/*My old version is below:
public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0.0, n);
        int x = n;
        int k = 0;
        int[] arr = new int[n];
        if((n & 1) == 1) {
            for(int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }
        else {
            for(int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            if((arr[i] & 1) == 1) {
                for(int j = 0; j < n; j += 2) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
                }
                for(int j = 1; j < n; j += 2) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
                }
            }
            else {
                for(int j = 0; j < n; j += 2) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
                }
                for(int j = 1; j < n; j += 2) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
                }
            }
        }                    
    }
}*/

/*A better version is below:
public class Checkerboard {

    public static void main(String[] args){
                int n = Integer.parseInt(args[0]);
                StdDraw.setXscale(0, n);
                StdDraw.setYscale(0, n);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if ((i + j) % 2 != 0) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        else                  StdDraw.setPenColor(StdDraw.BLUE);
                        StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                    }
                }
    }
}*/
