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

/* Variant:
public class ThueMorse {

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] thue = new int[n];

        for(int i=0; i<n; i++){
            if(i==0) thue[i] = 0;
            else if(i%2 == 0) thue[i] = thue[i/2];
            else thue[i] = 1 - thue[i-1];
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(thue[i] == thue[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }


    }
}

Variant 2

public class ThueMorse { 
   public static void main(String[] args) { 
     int N = Integer.parseInt(args[0]);
     int [] seq= new int [N]; 
	 
     for (int i=0; i<N; i++){
     	if (i==0) seq[i]=0;
		 else if (i%2==0) seq[i] = seq[i / 2] ;
		 else seq[i] = 1 - seq[i - 1];
     }
    
    for (int i=0; i<N; i++)
    {
      for(int j=0; j<N; j++){
    	if (seq[i] == seq[j]) System.out.print("+");
      		else System.out.print("-");
    	
    }
     System.out.println();
    }
     
     
	}
}

*/
