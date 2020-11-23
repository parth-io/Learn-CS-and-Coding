import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        String file = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(file);
        
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        
        // Prepare StdDraw and the barchart
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        
        while (in.hasNextLine()) {
            int n = 0;
            String input = in.readLine();
            
            if (input.equals("")) {
                n = Integer.parseInt(in.readLine());
                String year = "";
                Bar[] bars = new Bar[n];
                String[] fields = new String[5];
                
                // Get the input and enter it into an array
                for (int i = 0; i < n; i++) {
                    String line = in.readLine();
                    fields = line.split(",");
                    if (i == 0) {
                        year = fields[0];
                    }
                    bars[i] = new Bar(fields[1], Integer.parseInt(fields[3]), fields[4]);
                }
                
                // Sort the arrays
                Arrays.sort(bars);
                
                // Add the biggest values first to the barchart
                for (int i = (n - 1); i >= (n - k); i--) {
                    chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
                }
                
                // Draw the barchart
                StdDraw.clear();
                chart.setCaption(year);
                chart.draw();
                StdDraw.show();
                StdDraw.pause(100);
                chart.reset();
            }
        }
    }
}

/*
Soundtrack (optional). If you would like a musical accompaniment to your animated bar chart, add the following line at the beginning of your program:

StdAudio.loop("soundtrackA.wav");

Feel free to substitute a different .wav file.

My program doesn’t use the country field. Is that a problem?
    No. While this field is part of the input file format, you will not need that field in this program. 

How does BarChart determine which color to color the bars?
    It associates each category (e.g., South Asia) with one of 20 predefined colors. If there are more than 20 categories, two entries from two different categories may share the same color. 
*/
