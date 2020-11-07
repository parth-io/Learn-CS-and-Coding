public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int sum = 0;
        int x = 0;
        int y = 0;
        System.out.println("(0, 0)");
        while ((Math.abs(x) + Math.abs(y)) < r) {
            int a = ((int) (Math.random() * 4.0));
            if (a == 0) x += 1;
            else if (a == 1) x -= 1;
            else if (a == 2) y += 1;
            else if (a == 3) y -= 1;
            sum++;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + sum);
    }
}

/*
An alternative:
public class RandomWalker {

    public static void main(String[] args){
        int r = Integer.parseInt(args[0]);

        int i=0;
        int j=0;

        int count =0;

        while((Math.abs(i) + Math.abs(j)) != r){
            System.out.println("(" + i + "," +j + ")");
            double rand = Math.random();

            if(rand<0.25){
                i++;
            }

            else if(rand <0.5){
                j++;
            }
            else if(rand<0.75){
                i--;
            }
            else{
                j--;
            }
            count++;
        }

        System.out.println("(" + i + "," +j + ")");

        System.out.println("steps = " + count);
    }
}
*/
