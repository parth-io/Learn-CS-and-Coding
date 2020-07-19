public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // number of possible bds
        int trials = Integer.parseInt(args[1]); // number of trials to do
        int[] number_Trials = new int[2 + (n * n)]; // array for number of trials taken, with index
        for (int z = 0; z < trials; z++) {
            boolean[] room = new boolean[n]; // array of booleans for bds
            int number_Of_People = 0;
            //System.out.println("---------");
            while (true) {
                //System.out.println(java.util.Arrays.toString(room));
                int bd = (int) (Math.random() * n);
                number_Of_People += 1;
                //System.out.println("People: " + number_Of_People +"\nCurrent BD: " + bd);
                if (room[bd]) {
                    number_Trials[number_Of_People] += 1;
                    //System.out.println("Adding: " + number_Of_People);
                    //System.out.println(java.util.Arrays.toString(number_Trials));
                    break;
                }
                else if (!(room[bd])) {
                    room[bd] = true;
                }
            }
        }
        double fraction = 0.0;
        System.out.println(1 + " " + 0 + " " + fraction);
        int i = 2;
        while ((fraction < 0.5)) {
            int temp = number_Trials[i];
            number_Trials[i] = number_Trials[i] + number_Trials[i - 1];
            double x = number_Trials[i];
            fraction = x / trials;
            System.out.printf("%-8d%-8d%-8.6f\n", i, temp, fraction);
            i++;
        }
    }
}
