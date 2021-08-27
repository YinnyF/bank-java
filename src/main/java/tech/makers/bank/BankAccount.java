package tech.makers.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private ArrayList<ITransaction> transactions = new ArrayList();

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

        // How to decouple this?
        ITransaction transaction = new Transaction(date, amount, 0, balance);
        transactions.add(transaction);
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

        // How to decouple this?
        ITransaction transaction = new Transaction(date, 0, amount, balance);
        transactions.add(transaction);
    }

    public ArrayList<ITransaction> getTransactions() {
        return transactions;
    }

    public String generateStatement() {
        // need to isolate this too
        Statement statement = new Statement();
        return statement.print(getTransactions());
    }
}
