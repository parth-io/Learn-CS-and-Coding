public class ActivationFunction {

    public static double heaviside(double x) {
        if(x<0) return 0.0;
        else if(x==0) return 0.5;
        else if(x>0) return 1.0;
        else return Double.NaN;
    }

    public static double sigmoid(double x) {
        return 1/(1+(1/Math.exp(x)));
    }

    public static double tanh(double x) {
        if(x >= 20){
            return 1.0;
        }
        else if(x <= -20){
            return -1.0;
        }
        double t = Math.exp(x);
        return (t-(1/t)) / (t+(1/t));
    }

    public static double softsign(double x) {
        if (Double.isInfinite(x)) {
            if (x > 0) {
                return 1.0;
            }
            else {return -1.0;}
        }
        else {
            return x/(1+Math.abs(x));
        }
    }

    public static double sqnl(double x) {
        if(x<= -2) return -1.0;
        else if(x<0) return (x + ((x*x)/4));
        else if(x<2) return (x - ((x*x)/4));
        else if(x>=2) return 1.0;
        else return Double.NaN;
    }

    public static void main(String[] args) {
         double x = Double.parseDouble(args[0]);
         double heave, sig, tanh, soft, sqnl;
         if (Double.isNaN(x)) {
            heave = Double.NaN;
            sig = Double.NaN;
            tanh = Double.NaN;
            soft = Double.NaN;
            sqnl = Double.NaN;
         }
         else {
            heave = heaviside(x);
            sig = sigmoid(x);
            tanh = tanh(x);
            soft = softsign(x);
            sqnl = sqnl(x);
         }
         System.out.printf("%1$10s%2$s%3$s%4$s%n", "heaveside(", x, ") = ", heave);
         System.out.printf("%1$10s%2$s%3$s%4$s%n", "sigmoid(", x, ") = ", sig);
         System.out.printf("%1$10s%2$s%3$s%4$s%n", "tanh(", x, ") = ", tanh);
         System.out.printf("%1$10s%2$s%3$s%4$s%n", "softsign(", x, ") = ", soft);
         System.out.printf("%1$10s%2$s%3$s%4$s%n", "sqnl(", x, ") = ", sqnl);
    }
}
