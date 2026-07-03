import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * QN2 - Exceptions, finally, and resource handling.
 */
public class ExceptionHandlingDemo {

    // (a) try/finally return-value behaviour
    static int risky() {
        int x = 10;
        try {
            x = 20;
            return x; // the value 20 is captured here BEFORE finally runs
        } finally {
            x = 30; // this reassignment does NOT change the already-captured return value
            System.out.println("finally executed, x = " + x);
        }
    }

    // (b) try/catch/finally behaviour across different inputs
    static int risky(int x) {
        try {
            int result = 10 / x;
            return result;
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
            return -1;
        } finally {
            System.out.println("Cleanup for x = " + x);
        }
    }

    // (d) try-with-resources - reader is always closed, exception or not
    static void readFileSafely(String path) {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // (a)
        int result = risky();
        System.out.println("Returned: " + result);

        System.out.println("----");

        // (b)
        System.out.println("risky(0) returned: " + risky(0));
        System.out.println("risky(2) returned: " + risky(2));

        System.out.println("----");

        // (c)
        Wallet wallet = new Wallet(5000);
        try {
            wallet.withdraw(10000);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        System.out.println("----");

        // (d)
        readFileSafely("data.txt");
    }
}
