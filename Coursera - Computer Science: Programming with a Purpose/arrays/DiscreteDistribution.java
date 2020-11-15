public class DiscreteDistribution {
    public static void main(String[] args) {
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
            while (!((arr[i] <= r) && (arr[i + 1] > r))) {
                i++;
            }
            System.out.print((i + 1) + " ");
        }
    }
}

/* Alternative ans:
public class DiscreteDistribution {

    public static void main(String[] args){
        int n = args.length;
        int m = Integer.parseInt(args[0]);
        int[] a = new int[n-1];
        int[] s = new int[n-1];

        for(int i=0; i<n-1; i++){
            a[i] = Integer.parseInt(args[i+1]);
        }

        s[0] = a[0];
        for(int i=1; i<n-1; i++){
            s[i] = s[i-1] + a[i];
        }

        for(int i=0; i<m; i++){
            int r = (int) (Math.random() * s[n-2]);
            //System.out.println("r =" +r);
            for(int j=0; j<n-1; j++){
                if(r<s[j]){
                    System.out.print(j+1 + " ");
                    break;
                }
            }
        }

    }
}

Alternative 2

public class  DiscreteDistribution{
	public static void main(String[] args){
		int n=args.length;
		int m=Integer.parseInt(args[0]);
		int delta=0;
		int [] distribution=new int [n];
		for (int i=1; i<n; i++){
			distribution[i-1]=Integer.parseInt(args[i]);
			delta+=distribution[i-1];
		}
		int r=0;
		for (int j=0; j<m; j++){
			r= (int)(delta*Math.random());
			int k=0;
			int minValue=0;
			int maxValue=0;
			while(r>=minValue){
				minValue+=distribution[k];
				k++;
				}
		System.out.print(k+" ");
	}
	System.out.println();
	}
	
}
*/
