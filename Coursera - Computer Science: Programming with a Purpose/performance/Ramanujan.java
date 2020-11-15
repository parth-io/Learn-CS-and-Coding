public class Ramanujan {

    public static boolean isRamanujan(long n) {
        long max = (long) Math.ceil(Math.cbrt(n));
        long b_Cube = 0;
        boolean first = false;
        boolean second = false;
        long i_Cube = 0;
        double b_Cbrt = 0.0;
        long a = 0;
        for (long i = 1; i <= max; i++) {
            i_Cube = i * i * i;
            b_Cube = n - i_Cube;
            b_Cbrt = Math.cbrt(b_Cube);
            /*
            //What this if statement does is to check if b_cbrt is a decimal or a whole number. An alternative way is to do b_cube - ((long) b_cube)) == 0
            */
            if ((b_Cbrt % 1 == 0) && (b_Cbrt > 0)) {
                if (!first) {
                    a = i_Cube;
                    first = true;
                }
                else if (b_Cube != a) {
                    second = true;
                    break;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
