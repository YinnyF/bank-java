package tech.makers.bank;
import java.time.LocalDate;

public class Transaction implements ITransaction {
    private final LocalDate date;
    private final double credit;
    private final double debit;
    private final double balance;

    public Transaction(LocalDate date, double credit, double debit, double balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getCredit() {
        return credit;
    }

    public double getDebit() {
        return debit;
    }

    public double getRunningBalance() {
        return balance;
    }
}

