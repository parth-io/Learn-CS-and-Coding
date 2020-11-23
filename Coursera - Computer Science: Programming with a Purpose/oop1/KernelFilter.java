import java.awt.Color;

public class KernelFilter {

    // Method to convert values to int and to check for legality of values
    private static Color checkValue(double redValue, double greenValue, double blueValue) {
        int[] colors = new int[3];
        colors[0] = (int) Math.round(redValue);
        colors[1] = (int) Math.round(greenValue);
        colors[2] = (int) Math.round(blueValue);
        for (int i = 0; i < 3; i++) {
            if (colors[i] < 0 || colors[i] > 255) {
                if (colors[i] < 0) {
                    colors[i] = 0;
                }
                else {
                    colors[i] = 255;
                }
            }
        }
        Color newValue = new Color(colors[0], colors[1], colors[2]);
        return newValue;
    }    

    // Initialise a new picture and calls the helper method addValue to add the value of each individual pixel
    private static Picture kernel(Picture picture, double[][] weights) {
        int width = picture.width();
        int height = picture.height();
        Color[][] values = new Color[width][height];
        Picture pic = new Picture(width, height);
        // I used iWeights here to get -1 ... 1 if kernel is 3 by 3, and -4 ...  4 if kernel is 9 by 9
        // Alternatively, I could have just iterated from 0 to (weights.length-1) in the double for-loop; then, calculated a and b by doing a = Math.floorMod(((-(weights.length - 1) / 2) + x), width); then gotten the coloured values by using weights[x][y]
        int iWeights = (weights.length - 1) / 2;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double redValue = 0;
                double greenValue = 0;
                double blueValue = 0;
                for (int x = -iWeights; x <= iWeights; x++) {
                    for (int y = -iWeights; y <= iWeights; y++) {
                        // This took a while to figure out, if it was not for the hint in the FAQ I never could have done this. Math.floorMod is similar in nature to the modulo operator %, but not the same - but it takes care of the boundary conditions for us
                        int a = Math.floorMod((i + x), width);
                        int b = Math.floorMod((j + y), height);
                        if (values[a][b] == null) {
                                values[a][b] = picture.get(a, b);
                        }
                        redValue += weights[(x + iWeights)][(y + iWeights)] * values[a][b].getRed();
                        greenValue += weights[(x + iWeights)][(y + iWeights)] * values[a][b].getGreen();
                        blueValue += weights[(x + iWeights)][(y + iWeights)] * values[a][b].getBlue();
                    }
                }
                pic.set(i, j, checkValue(redValue, greenValue, blueValue));
            }
        }
        return pic;
    }

    public static Picture identity(Picture picture) {
        double[][] weights = new double[3][3];
        weights[1][1] = 1.0;
        picture = kernel(picture, weights);
        return picture;
    }
    
    public static Picture gaussian(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = 1.0 / 16.0;
        weights[0][1] = 1.0 / 8.0;
        weights[0][2] = weights[0][0];
        weights[1][0] = weights[0][1];
        weights[1][1] = 1.0 / 4.0;
        weights[1][2] = weights[0][1];
        weights[2][0] = weights[0][0];
        weights[2][1] = weights[0][1];
        weights[2][2] = weights[0][0];
        picture = kernel(picture, weights);
        return picture;
    }
    
    public static Picture sharpen(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = 0;
        weights[0][1] = -1.0;
        weights[0][2] = 0;
        weights[1][0] = -1.0;
        weights[1][1] = 5.0;
        weights[1][2] = -1.0;
        weights[2][0] = 0;
        weights[2][1] = -1.0;
        weights[2][2] = 0;
        picture = kernel(picture, weights);
        return picture;
    }
    
    public static Picture laplacian(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = -1.0;
        weights[0][1] = -1.0;
        weights[0][2] = -1.0;
        weights[1][0] = -1.0;
        weights[1][1] = 8.0;
        weights[1][2] = -1.0;
        weights[2][0] = -1.0;
        weights[2][1] = -1.0;
        weights[2][2] = -1.0;
        picture = kernel(picture, weights);
        return picture;
    }

    public static Picture emboss(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = -2.0;
        weights[0][1] = -1.0;
        weights[0][2] = 0;
        weights[1][0] = -1.0;
        weights[1][1] = 1.0;
        weights[1][2] = 1.0;
        weights[2][0] = 0;
        weights[2][1] = 1.0;
        weights[2][2] = 2.0;
        picture = kernel(picture, weights);
        return picture;
    }
    
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        weights[0][0] = 1.0 / 9.0;
        weights[1][1] = 1.0 / 9.0;
        weights[2][2] = 1.0 / 9.0;
        weights[3][3] = 1.0 / 9.0;
        weights[4][4] = 1.0 / 9.0;
        weights[5][5] = 1.0 / 9.0;
        weights[6][6] = 1.0 / 9.0;
        weights[7][7] = 1.0 / 9.0;
        weights[8][8] = 1.0 / 9.0;
        picture = kernel(picture, weights);
        return picture;
    }
    
    public static void main(String[] args) {   
        Picture picture = new Picture("path_to_file/baboon.png");
        Picture pic = sharpen(picture);
        pic.show();
        pic = identity(picture);
        pic.show();
        pic = emboss(picture);
        pic.show();
        pic = motionBlur(picture);
        pic.show();
        pic = laplacian(picture);
        pic.show();
        pic = gaussian(picture);
        pic.show();
    }
}
/*
    Why use periodic boundary conditions?
    Periodic boundary conditions (also known as circular or toroidal boundary conditions) are simple to implement, but not the only reasonable choice. Other common boundary conventions include

        Dirichlet: treat out-of-bounds pixels as black or zero.

        Neumann: compute out-of-bounds pixels by mirror-reflecting the array across the array border.

        Replicate: treat out-of-bounds pixel as equal to the nearest array border pixel. 

    Different boundary conditions work best in different situations. Image-processing libraries often provide the user a choice of boundary conditions.
    
How I applied the kernel filter for each filter originally - for 0 < i < width and 0 < j < height - I ignored the boundary conditions initially
for (int x = -1; x < 2; x++) {
    for (int y = -1; y < 2; y++) {
        if (values[(i + x)][(j + y)] == null) {
                values[(i + x)][(j + y)] = picture.get((i + x), (j + y));
        }
        redValue += weights[(x + 1)][(y + 1)] * values[(i + x)][(j + y)].getRed();
        //System.out.println(redValue);
        greenValue += weights[(x + 1)][(y + 1)] * values[(i + x)][(j + y)].getGreen();
        blueValue += weights[(x + 1)][(y + 1)] * values[(i + x)][(j + y)].getBlue();
    }
}
*/
