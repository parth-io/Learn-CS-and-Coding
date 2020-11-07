public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double total = 0;
        for (int i = 0; i < trials; i++) {
            int sum = 0;
            int x = 0;
            int y = 0;
            while ((Math.abs(x) + Math.abs(y)) < r) {
                int a = ((int) (Math.random() * 4.0));
                if (a == 0) x += 1;
                else if (a == 1) x -= 1;
                else if (a == 2) y += 1;
                else if (a == 3) y -= 1;
                sum++;
            }
            total += sum;
        }
        double av = total / trials;
        System.out.println("average number of steps = " + av);
    }
}
