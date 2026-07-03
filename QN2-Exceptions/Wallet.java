public class Wallet {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds: balance is " + balance + ", requested " + amount);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
