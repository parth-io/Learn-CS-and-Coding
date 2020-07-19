public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int power = 0;
        while (Math.pow(2, power) < n) {
            power++;
        }
        int[] arr = new int[(int) (Math.pow(2, power))];
        for (int i = 1; i <= power; i++) {
            for (int j = (int) (Math.pow(2, (i - 1))); j < (int) (Math.pow(2, i)); j++) {
                arr[j] = 1 ^ (arr[j - (int) (Math.pow(2, (i - 1)))]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
