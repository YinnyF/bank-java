package tech.makers.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Statement {
    private final String header = "date || credit || debit || balance\n";

    public String print() {
        return header;
    }

    public String print(ArrayList<Transaction> transactions) {
        String stringOfTransactions = createStringOfTransactions(transactions);
        return header + stringOfTransactions;
    }

    private String createStringOfTransactions(ArrayList<Transaction> transactions) {
        StringBuilder stringOfTransactions = new StringBuilder();
        for(Transaction transaction : transactions) {
            stringOfTransactions.append(createTransactionLine(transaction));
        }

        return stringOfTransactions.toString();
    }

    private String createTransactionLine(Transaction transaction) {
        String date = formatDate(transaction.getDate());
        String credit = formatAmount(transaction.getCredit());
        String debit = formatAmount(transaction.getDebit());
        String balance = formatAmount(transaction.getRunningBalance());

        return String.join(" || ", date, credit, debit, balance) + "\n";
    }

    private String formatDate(LocalDate date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return formattedDate;
    }

    private String formatAmount(double amount) {
        String formattedAmount;
        if (amount == 0 ) {
            formattedAmount = "-";
        } else {
            formattedAmount = String.format("%.2f", amount);
        }

        return formattedAmount;
    }
}
