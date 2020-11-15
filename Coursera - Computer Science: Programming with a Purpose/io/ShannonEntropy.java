public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] values = new int[m + 1];
        
        int count = 0;
        while(!(StdIn.isEmpty())) {
            int i = StdIn.readInt();
            values[i]++;
            count++;
        }
        //You can combine the 2 loops here by using while (!StdIn.isEmpty())
        double entropy = 0.0;
        for(int i = 1; i <= m; i++) {
            if(!(values[i] == 0)){
                double p = (double) values[i]/count;
                double temp = (p) * (Math.log(p) / Math.log(2));
                entropy = entropy - temp;
            }
        }
        StdOut.printf("%.4f\n", entropy);
    }
}
