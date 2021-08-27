package tech.makers.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private float balance;
    private ArrayList<String> transactions = new ArrayList();

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

    public void deposit(float amount, LocalDate date) {
        checkValid(amount);

        balance += amount;

        transactions.add("deposit");
    }

    private void checkFunds(float amount) {
        if (amount > balance) {
            throw new ArithmeticException("Not enough funds");
        }
    }

    public void withdraw(float amount, LocalDate date) {
        checkValid(amount);
        checkFunds(amount);

        balance -= amount;

        transactions.add("withdrawal");
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }
}
