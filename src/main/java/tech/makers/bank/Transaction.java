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

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public double getCredit() {
        return credit;
    }

    @Override
    public double getDebit() {
        return debit;
    }

    @Override
    public double getRunningBalance() {
        return balance;
    }
}

