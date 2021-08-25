package tech.makers.bank;

public class BankAccount {
    private float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    private void checkValid(float amount) {
        if (amount < 0 || amount * 100 % 1 != 0) {
            throw new ArithmeticException("Invalid amount");
        }
    }

    public void deposit(float amount) {
        checkValid(amount);

        balance += amount;
    }

    private void checkFunds(float amount) {
        if (amount > balance) {
            throw new ArithmeticException("Not enough funds");
        }
    }

    public void withdraw(float amount) {
        checkValid(amount);
        checkFunds(amount);

        balance -= amount;
    }
}
