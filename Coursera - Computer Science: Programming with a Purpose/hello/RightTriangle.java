public class RightTriangle {
    public static void main(String[] args) {
        boolean value = false;
        boolean valued = false;
        long x = Long.parseLong(args[0]);
        long y = Long.parseLong(args[1]);
        long z = Long.parseLong(args[2]);
        value = x > 0 && y > 0 && z > 0;
        long xx = x * x;
        long yy = y * y;
        long zz = z * z;
        long xxyy = xx + yy;
        long yyzz = yy + zz;
        long xxzz = xx + zz;
        valued = ((xxyy == zz) || (yyzz == xx) || (xxzz == yy));
        valued = value && valued;
        System.out.println(valued);
    }
}

/* A concise version:
public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.println( (c*c == a*a + b*b || b*b == a*a + c*c || a*a == b*b + c*c) && (c>0 && b>0 && a>0));
}
}
*/
