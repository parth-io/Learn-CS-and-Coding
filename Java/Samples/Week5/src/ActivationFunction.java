public class ActivationFunction {

    public static double heaviside(double x){
        if(x<0) return 0.0;

        else if(x==0) return 0.5;

        else return 1.0;

    }

    public static double sigmoid(double x){
        return 1/(1+(1/Math.exp(x)));
    }

    public static double tanh(double x){
        if(x >= 20){
            return 1.0;
        }
        else if(x <= -20){
            return -1.0;
        }
        double t = Math.exp(x);
        return (t-(1/t)) / (t+(1/t));
    }

    public static double softsign(double x){
        return x/(1+Math.abs(x));
    }

    public static double sqnl(double x){
        if(x<= -2) return -1.0;

        else if(x<0) return (x + ((x*x)/4));

        else if(x<2) return (x - ((x*x)/4));

        else return 1.0;
    }

    public static void main(String[] args){
         double x = Double.parseDouble(args[0]);

         double heave = heaviside(x);
         double sig = sigmoid(x);
         double tanh = tanh(x);
         double soft = softsign(x);
         double sqnl = sqnl(x);

         System.out.println("heaveside(" + x + ")" + " = " + heave);
         System.out.println("sigmoid(" + x + ")" + " = " + sig);
         System.out.println("tanh(" + x + ")" + " = " + tanh);
         System.out.println("softsign(" + x + ")" + " = " + soft);
         System.out.println("sqnl(" + x + ")" + " = " + sqnl);


    }
}
