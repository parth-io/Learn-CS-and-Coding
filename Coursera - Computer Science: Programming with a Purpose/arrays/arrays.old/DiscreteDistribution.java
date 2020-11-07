public class DiscreteDistribution {
    public static void main (String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(args[i + 1]) + arr[i];
        }
        for (int j = 0; j < m; j++) {
            int r = ((int) (Math.random() * arr[n]));
            int i = 0;
            while ((arr[i] < r) && (arr[i + 1] > r) == false) {
                i++;
            }
            System.out.print((i + 1) + " ");
        }
    }
}
