package tech.makers.bank;
import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float balance;
    private final float debit;

    public Transaction(float debit, float balance) {
        this.date = LocalDate.now();
        this.balance = balance;
        this.debit = debit;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getRunningBalance() {
        return balance;
    }

    public float getDebit() {
        return debit;
    }
}
