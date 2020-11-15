public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // number of possible bds
        int trials = Integer.parseInt(args[1]); // number of trials to do
        int[] number_Trials = new int[2 + (n * n)]; // array for number of trials taken, with index
        for (int z = 0; z < trials; z++) {
            boolean[] room = new boolean[n]; // array of booleans for bds
            int number_Of_People = 0;
            //System.out.println("---------");
            while (true) {
                //System.out.println(java.util.Arrays.toString(room));
                int bd = (int) (Math.random() * n);
                number_Of_People += 1;
                //System.out.println("People: " + number_Of_People +"\nCurrent BD: " + bd);
                if (room[bd]) {
                    number_Trials[number_Of_People] += 1;
                    //System.out.println("Adding: " + number_Of_People);
                    //System.out.println(java.util.Arrays.toString(number_Trials));
                    break;
                }
                else if (!(room[bd])) {
                    room[bd] = true;
                }
            }
        }
        double fraction = 0.0;
        System.out.println(1 + " " + 0 + " " + fraction);
        int i = 2;
        while ((fraction < 0.5)) {
            int temp = number_Trials[i];
            number_Trials[i] = number_Trials[i] + number_Trials[i - 1];
            double x = number_Trials[i];
            fraction = x / trials;
            System.out.printf("%-8d%-8d%-8.6f\n", i, temp, fraction);
            i++;
        }
    }
}

/* Alternative:
public class Birthday {

    public static void main(String[] args){

        int days = Integer.parseInt(args[0]);  //days of the people
        int trails = Integer.parseInt(args[1]);
        int[] counter = new int[days+2];
        double fraction = 0.0;
        counter[0] = 0;

        System.out.println(1 + " " + 0 + " " + fraction);

        int k =1;

        while(fraction < 0.5){

            counter[k]=0;
            for(int i=0; i<trails; i++){
                //  hasBirthday[d] = true if someone born on day d; false otherwise
                boolean[] hasBirthday = new boolean[days];

                int  people = 0;
                while (true) {
                    people++;                               // one more person enters the room
                    int d = (int) (days * Math.random());   // integer between 0 and days-1
                    if (hasBirthday[d]) break;              // found two people with the same birthday
                    hasBirthday[d] = true;                  // update array
                }

                if(people == k+1){
                    counter[k]++;
                }
            }
            fraction = fraction + (double) counter[k]/trails;
            System.out.println(k+1 + "\t" + counter[k] + "\t" + fraction);
            k++;

        }

    }
}

Alternative 2

public class Birthday { 

    public static void main(String[] args) { 
        int days = Integer.parseInt(args[0]);     // number of days
        int people = 0;                           // total number of people

        //  hasBirthday[d] = true if someone born on day d; false otherwise
        //  auto-initialized to false
        boolean[] hasBirthday = new boolean[days];

        while (true) {
            people++;
            int d = (int) (days * Math.random());    // integer between 0 and days-1
            if (hasBirthday[d]) break;               // two people with the same birthday, so break out of loop
            hasBirthday[d] = true;                   // update array
        }

        System.out.println(people);
    }
}
*/
