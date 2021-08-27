package tech.makers.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private ArrayList<String> transactions = new ArrayList();

    public BankAccount() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    private void checkValid(double amount) {
        if (amount < 0 || amount * 100 % 1 != 0) {
            throw new ArithmeticException("Invalid amount");
        }
    }

    public void deposit(double amount, LocalDate date) {
        checkValid(amount);

        balance += amount;

        transactions.add("deposit");
    }

    private void checkFunds(double amount) {
        if (amount > balance) {
            throw new ArithmeticException("Not enough funds");
        }
    }

    public void withdraw(double amount, LocalDate date) {
        checkValid(amount);
        checkFunds(amount);

        balance -= amount;

        transactions.add("withdrawal");
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }
}
