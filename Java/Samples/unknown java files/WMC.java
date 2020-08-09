import java.util.*;
public class WMC {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] reg_number = new String[m];
        String[] name = new String[m];
        float[] rating = new float[m];
        for(int i=0; i<m; i++){
            String s;
            String[] s_vec;
            s = sc.nextLine();
            s_vec = s.split(",");
            reg_number[i] = s_vec[0];
            name[i] = s_vec[1];
            rating[i] = Float.parseFloat(s_vec[2]);
        }

        for(int i=0; i<m; i++){
            System.out.print(i+1 + " ");
            System.out.print(reg_number[i] + " ");
            int average = (int) Math.round((rating[i]/5.0)*100);
            for(int j=0; j<n; j++){
                System.out.print(average + ",");
            }
            System.out.println();
        }


    }
}
