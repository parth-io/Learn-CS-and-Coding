public class Birthday {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] room = new int[n];
        int[] count = new int[n];
        for (int z = 0; z < trials; z++) {
            for (int i = 0; i < n; i++) {
                int bd = (int) (Math.random() * n);
                boolean value = false;
                room[i] = bd;
                for (int j = 0; j < i; j++) {
                    if (bd == room[j]) {
                        value = true;
                        break;
                    }
                }
                if (value == true) {
                    count[i] += 1;
                    break;
                }
            }
        }
        System.out.printf("%-8d%-8d%-8d\n", 1, 0, 0);
        double fraction = 0.0d;
        int i = 2;
        while (fraction < 0.5) {
            int temp = count[i - 1];
            count[i - 1] = count[i - 1] + count[i - 2];
            double x = count[i - 1];
            fraction = x / trials;
            System.out.printf("%-8d%-8d%-8.6f\n", i, temp, fraction);
            i++;
        }
    }
}
