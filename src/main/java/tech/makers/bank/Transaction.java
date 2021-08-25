package tech.makers.bank;
import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float balance;

    public Transaction(float balance) {
        this.date = LocalDate.now();
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getRunningBalance() {
        return balance;
    }
}
