public class RecursiveSquares {

    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;

        drawSquare(x, y, length);
        
        draw(n-1, x - length/2, y - length/2, length/2);     
        draw(n-1, x - length/2, y + length/2, length/2);    
        draw(n-1, x + length/2, y - length/2, length/2);    
        draw(n-1, x + length/2, y + length/2, length/2);    
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;
        double length = 0.5;
        draw(n, x, y, length);
    }

}

/* My first try - failed the autograder because loops are not allowed

Bug to fix: The squares keep getting redrawn, it is a requirement of the question that that the newer and smaller squares overlap across the older squares, but surely I don't have to keep redrawing the big and small squares to achieve this?

public class RecursiveSquares {

    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) { return; }
        for (int i = 1; i <= n; i++) {
            drawSquare(x, y, length);
            draw(n-1, x - length/2, y - length/2, length/2);
            draw(n-1, x - length/2, y + length/2, length/2);
            draw(n-1, x + length/2, y - length/2, length/2);
            draw(n-1, x + length/2, y + length/2, length/2);
        }
    }

    public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double x = 0.5, y = 0.5, length = 0.5;
    draw(n, x, y, length);
    }
}
*/

/* My attempt at fixing my first try
My fix: But the thing is, I don't get how why only the upper-right one is drawn, and secondly how the new x and y coordinates are recursively calculated even when my program doesn't calculate the new x and y, like the new x should be equal to x + length/2 and this new x should be saved in order to be used to draw the subsequent squares 

public class RecursiveSquares {

    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
    }

    public static void draw(int n, double x, double y, double length) {
        while (!(n == 0)) {
            length = length/2;
            drawSquare(x - length, y - length, length);
            drawSquare(x - length, y + length, length);
            drawSquare(x + length, y + length, length);
            drawSquare(x + length, y - length, length);
            n--;
        }
        return;
    }

    public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double x = 0.5, y = 0.5, length = 0.5;
    drawSquare(x, y, length);
    draw((n - 1), x, y, length);
    }
}

*/
