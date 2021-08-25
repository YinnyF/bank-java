package tech.makers.bank;
import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final float credit;
    private final float debit;
    private final float balance;

    public Transaction(LocalDate date, float credit, float debit, float balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getCredit() {
        return credit;
    }

    public float getDebit() {
        return debit;
    }

    public float getRunningBalance() {
        return balance;
    }
}

