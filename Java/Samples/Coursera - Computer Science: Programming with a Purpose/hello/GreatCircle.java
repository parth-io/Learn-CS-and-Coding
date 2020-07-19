public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        y2 = Math.pow(Math.sin((y2 - y1)/2), 2);
        y1 = Math.cos(x1) * Math.cos(x2);
        x1 = Math.pow(Math.sin((x2 - x1)/2), 2);
        x1 = x1 + y1 * y2;
        x1 = Math.sqrt(x1);
        x1 = 2 * 6371.0 * Math.asin(x1);
        System.out.println(x1 + " kilometers");
    }
}
