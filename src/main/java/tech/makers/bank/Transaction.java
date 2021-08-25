package tech.makers.bank;
import java.time.LocalDate;

public class Transaction {
    private LocalDate date;

    public Transaction() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }
}
