package tech.makers.bank;
import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float balance;
    private final float debit;
    private final float credit;

    public Transaction(float debit, float credit, float balance) {
        this.date = LocalDate.now();
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
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

    public float getCredit() {
        return credit;
    }
}
