public class BandMatrix {
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        double width = Double.parseDouble(args[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i <= (j + width)) && (i >= (j - width))) { //Another if statement - if((i-j) == r || (j-i) == r || i==j)
                //Or you could do Math.abs(i-j)<=width
                    System.out.print("*");
                }
                else {
                    System.out.print("0");
                }
                System.out.print("  ");
            }
        System.out.println();
        }
    }
}
