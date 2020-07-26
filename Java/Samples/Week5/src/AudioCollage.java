public class AudioCollage {

    public static double[] amplify(double[] a, double alpha){

        double[] c = new double[a.length];
        for(int i=0; i<a.length; i++){
            c[i] = a[i] * alpha;
        }

        return c;
    }

    public static double[] reverse(double[] a){

        double[] c = new double[a.length];

        int n = a.length;
        for (int i = n-1; i >= 0; i--) {
            c[n-i-1] = a[i];
        }

        return c;
    }

    public static double[] merge(double[] a, double[] b){
        int len = a.length + b.length;
        double[] c = new double[len];

        for(int i=0; i<len; i++){
            if(i < a.length){
                c[i] = a[i];
            }
            else{
                c[i] = b[b.length+i-len];
            }
        }
        return c;
    }

    public static double[] mix(double[] a, double[] b){

        int len = a.length > b.length? a.length:b.length;
        double[] x = new double[len];
        double[] y = new double[len];

        for(int i=0; i<a.length; i++){
            x[i] = a[i];
        }

        for(int i=0; i<b.length; i++){
            y[i] = b[i];
        }

        double[] c = new double[len];

        for(int i=0; i<len; i++){
            c[i] = x[i] + y[i];
        }

        return c;
    }

    public static double[] changeSpeed(double[] a, double alpha){
        int n = a.length;

        int m = (int)Math.floor(n/alpha);

        double[] c = new double[m];

        for(int i=0; i<m; i++){
            int k = (int)Math.floor(i*alpha);
            c[i] = a[k];
        }

        return c;
    }



    public static void main(String[] args){

        double[] A = new double[44100];
        double[] B = new double[44100];

         A =  StdAudio.read("beatbox.wav");
         B =  StdAudio.read("chimes.wav");

         double alpha = 1.5;

         StdAudio.play(amplify(A, alpha));
         StdAudio.play(reverse((A)));
         StdAudio.play(merge(A, B));
         StdAudio.play(mix(A, B));
         StdAudio.play(changeSpeed(A, alpha));


    }
}
