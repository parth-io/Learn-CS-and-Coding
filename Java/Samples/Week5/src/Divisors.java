public class Divisors {


    public static int gcd(int a, int b){

        if(a ==0 && b==0){
            return 0;
        }
        int x = Math.abs(a);
        int y = Math.abs(b);

        while(y != 0){
            int t = y;
             y = x%y;
             x = t;
        }

        return x;
    }

    public static int lcm(int a, int b){

        if(a ==0 || b ==0) return 0;
        int x= Math.abs(a);
        int y = Math.abs(b);

        int lc = (x*y)/ gcd(x, y);

        return lc;
    }

    public static boolean areRelativelyPrime(int a, int b){
         if(gcd(a, b) == 1){
             return true;
         }
         else return false;
    }

    public static int totient(int n){

        if(n <= 0) return 0;
        else{
            int count =0;
            for(int i=1; i<n; i++){
                if(areRelativelyPrime(i, n)){
                    count++;
                }
            }

            return count;
        }

    }

    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int gc = gcd(a, b);
        int lc = lcm(a, b);
        boolean RP = areRelativelyPrime(a, b);
        int eul_a = totient(a);
        int eul_b = totient(b);



        System.out.println("gcd(" + a + "," + " " + b + ")" + " = " + gc);
        System.out.println("lcm(" + a + "," + " " + b + ")" + " = " + lc);
        System.out.println("areRelativelyPrime(" + a + "," + " " + b + ")" + " = " + RP);
        System.out.println("totient(" + a + ")" + " = " + eul_a);
        System.out.println("totient(" + b + ")" + " = " + eul_b);

    }
}
