package tech.makers.bank;

import java.time.LocalDate;

public interface ITransaction {
    LocalDate getDate();

    double getCredit();

    double getDebit();

    double getRunningBalance();
}
