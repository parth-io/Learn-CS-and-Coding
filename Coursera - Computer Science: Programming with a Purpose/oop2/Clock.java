public class Clock {

    // The autograder chewed my head off with multiple warnings over using numeric literals and for using a constant multiple times, so I was forced to do this
    private static final int hoursDay = 23;
    private static final int minutesHour = 59;
    
    private int hours;
    private int minutes;
    
    public Clock(int h, int m) {
        if ((h > hoursDay) || (h < 0) || (m > minutesHour) || (m < 0)) {
            throw new IllegalArgumentException("Integer arguments should be in their bounds - hours between 0 and 23, minutes between 0 and 59");
        }
        hours = h;
        minutes = m;
    }
    
    public Clock(String s) {
        if (!(s.length() == 5) || !(s.substring(2, 3).equals(":"))) {
            throw new IllegalArgumentException("Invalid format");
        }
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if ((h > hoursDay) || (h < 0) || (m > minutesHour) || (m < 0)) {
            throw new IllegalArgumentException("Integer arguments should be in their bounds - hours between 0 and 23, minutes between 0 and 59");
        }
        hours = h;
        minutes = m;
    }
    
    public String toString() {
        String a = String.format("%02d", hours);
        String b = String.format("%02d", minutes);
        return a + ":" + b;
    }
    
    public boolean isEarlierThan(Clock that) {
        if (this.hours == that.hours) {
            if (this.minutes == that.minutes) {
                return false;
            }
            else return (this.minutes < that.minutes);
        }
        else return (this.hours < that.hours);
    }
    
    public void tic() {
        if ((minutes + 1) < (minutesHour + 1)) {
            minutes++;
        }
        else {
            minutes = 0;
            hours++;
        }
        if (hours > hoursDay) {
            hours = 0;
        }
    }

    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Argument is negative");
        }
        int hoursToc = delta / (minutesHour + 1);
        int minutesToc = delta % (minutesHour + 1);
        hours += hoursToc;
        minutes += minutesToc;
        if (minutes > minutesHour) {
            minutes -= (minutesHour + 1);
            hours++;
        }
        if (hours > hoursDay) {
            hours = hours % (hoursDay + 1);
        }
    }
    
    public static void main(String[] args) {
        /*Clock test = new Clock("23:59");
        Clock testy = new Clock("23:59");
        test.isEarlierThan(testy);
        test.toc(2);
        test.tic();*/
        Clock test = new Clock("04:05");
        test.toc(2368);
        System.out.println(test);
    }
}
