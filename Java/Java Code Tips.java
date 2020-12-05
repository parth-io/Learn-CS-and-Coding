// Using Scanner
private static final Scanner scanner = new Scanner(System.in);

// Using BufferedWriter
public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int result = factorial(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();

// Using regex to check for whitespace
scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
