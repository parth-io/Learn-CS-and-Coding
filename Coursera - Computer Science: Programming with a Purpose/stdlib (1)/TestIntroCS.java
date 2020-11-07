/******************************************************************************
 *  Compilation:  javac-introcs TestIntroCS.java
 *  Execution:    java-introcs TestIntroCS n
 *  
 *  Play chaos game to produce Barnsley's fern.
 *  This program is intended to test that stdlib.jar is properly installed.
 *
 *  % java-introcs TestIntroCS 10000
 * 
 ******************************************************************************/

public class TestIntroCS {

    public static void main(String[] args) {
        int n = 10000;  // number of points to draw (default 10000)
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        StdDraw.setScale(-0.1, 1.1);              // leave a 10% border
        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);   // background color
        StdDraw.setPenColor(0, 114, 0);           // a shade of green

        // starting point
        double x = 0.5;
        double y = 0.0;

        // repeated choose one of four update rules at random
        for (int i = 0; i < n; i++) {
            double tempx, tempy;
            double r = StdRandom.uniform(0.0, 1.0);

            // stem
            if (r <= 0.01)  {
                tempx = 0.50;
                tempy = 0.16 * y;
            }

            // largest left-hand leaflet
            else if (r <= 0.08) {
                tempx =  0.20 * x - 0.26 * y + 0.400;
                tempy =  0.23 * x + 0.22 * y - 0.045;
            }

            // largest right-hand leaflet
            else if (r <= 0.15) {
                tempx = -0.15 * x + 0.28 * y + 0.575;
                tempy =  0.26 * x + 0.24 * y - 0.086;
            }

            // successively smaller leaflets
            else {
                tempx =  0.85 * x + 0.04 * y + 0.075;
                tempy = -0.04 * x + 0.85 * y + 0.180;
            }

            // update (x, y) and draw point
            x = tempx;
            y = tempy;
            StdDraw.point(x, y);
        }
    }   
}
