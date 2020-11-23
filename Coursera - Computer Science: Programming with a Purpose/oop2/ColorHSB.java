public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;
    
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ((h < 0) || (h > 359)) {
            throw new IllegalArgumentException("Argument entered is out of range, they should be from 0 to 359");
        }
        if ((s < 0) || (s > 100) || (b < 0) || (b > 100)) {
            throw new IllegalArgumentException("Argument(s) entered is(are) out of range, they should be from 0 to 100");
        }
        hue = h;
        saturation = s;
        brightness = b;
    }

    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }
    
    public boolean isGrayscale() {
        return (saturation == 0) || (brightness == 0);
    }
    
    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        return (int) (Math.min(Math.pow((this.hue - that.hue), 2), Math.pow((360 - Math.abs(this.hue - that.hue)), 2)) + Math.pow((this.saturation - that.saturation), 2) + Math.pow((this.brightness - that.brightness), 2));
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        
        ColorHSB input = new ColorHSB(h, s, b);
        
        // Do I test for isGrayscale?
        
        // 149600 represents the maximum possible distance between any two colours. How did I get this? 360^2 + 100^2 + 100^2
        int minimumDistance = 149600;
        int currentDistance = 0;
        String closestColor = "";
        String closestColorInt = "";
        
        while (!StdIn.isEmpty()) {
            String currentColor = StdIn.readString();
            int i1 = StdIn.readInt();
            int i2 = StdIn.readInt();
            int i3 = StdIn.readInt();
            
            ColorHSB that = new ColorHSB(i1, i2, i3);
            
            currentDistance = input.distanceSquaredTo(that);
            
            if (currentDistance < minimumDistance) {
                minimumDistance = currentDistance;
                closestColor = currentColor;
                closestColorInt = that.toString();
            }
        }
        System.out.println(closestColor + " " + closestColorInt);
    }
}
