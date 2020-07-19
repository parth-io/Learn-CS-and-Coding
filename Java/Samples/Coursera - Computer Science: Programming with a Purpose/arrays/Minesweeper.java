public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        
        int[][] arr = new int[m][n];
        int k_counter = k;
        int grid_counter = m * n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double r = Math.random();
                if (r <= ((k_counter * 1.0) / grid_counter)) {
                    arr[i][j] = 5;
                    k_counter -= 1;
                }
                grid_counter -= 1;
                
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 5) {
                    System.out.print("*  ");
                }
                else {
                    int count = 0;
                    if ((i - 1) >= 0 && (j - 1) >= 0) {
                        if (arr[i - 1][j - 1] == 5) {
                            count++;
                        }
                    }
                    if ((i - 1) >= 0) {
                        if (arr[i - 1][j] == 5) {
                            count++;
                        }
                    }
                    if ((i - 1) >= 0 && (j + 1) < n) {
                        if (arr[i - 1][j + 1] == 5) {
                            count++;
                        }
                    }
                    if ((j + 1) < n) {
                        if (arr[i][j + 1] == 5) {
                            count++;
                        }
                    }
                    if ((i + 1) < m && (j + 1) < n) {
                        if (arr[i + 1][j + 1] == 5) {
                            count++;
                        }
                    }
                    if ((i + 1) < m) {
                        if (arr[i + 1][j] == 5) {
                            count++;
                        }
                    }
                    if ((i + 1) < m && (j - 1) >= 0) {
                        if (arr[i + 1][j - 1] == 5) {
                            count++;
                        }
                    }
                    if ((j - 1) >= 0) {
                        if (arr[i][j - 1] == 5) {
                            count++;
                        }
                    }
                    System.out.print(count + "  ");
                }
            }
            System.out.println();
        }
    }
}
