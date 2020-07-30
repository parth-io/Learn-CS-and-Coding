public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0.0, (double) width);
        StdDraw.setYscale(0.0, (double) height);
        
        while(!StdIn.isEmpty()) { //can use StdIn.hasNextLine() also
            String region = StdIn.readString();
            int n = StdIn.readInt();
            
            double[] x = new double[n];
            double[] y = new double[n];
            
            for(int i = 0; i < n; i++){
                    x[i] = StdIn.readDouble();
                    y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}

/* Different one:

        while(!StdIn.isEmpty()){
*/
