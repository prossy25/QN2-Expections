// Checked exception: extends Exception, must be declared/caught
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
