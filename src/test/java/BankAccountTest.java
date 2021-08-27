import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.makers.bank.BankAccount;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private final BankAccount subject = new BankAccount();
    private final LocalDate date = LocalDate.of(2021, 1, 1);

    // Initial balance
    @Test
    void testHasStartingBalanceZero() {
        assertEquals(0, subject.getBalance());
    }

    // Depositing
    @Test
    void testDeposit() {
        subject.deposit(1, date);
        assertEquals(1, subject.getBalance());
    }

    @Test
    void testCannotDepositNegativeAmount() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.deposit(-1, date);
        });
    }

    @Test
    void testCannotDepositFractionalPennies() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.deposit(0.001f, date);
        });
    }

    // Withdrawals
    @Test
    void testWithdrawal() {
        subject.deposit(1, date);
        subject.withdraw(1, date);
        assertEquals(0, subject.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanBalance() {
        subject.deposit(1, date);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(2, date);
        });
    }

    @Test
    void testCannotWithdrawNegativeAmount() {
        subject.deposit(1, date);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(-1, date);
        });
    }

    // another way to test the error message
    @Test
    void testCannotWithdrawNegativeAmount2() {
        subject.deposit(1, date);
        Exception exception = assertThrows(ArithmeticException.class, () -> subject.withdraw(-1, date));
        assertEquals("Invalid amount", exception.getMessage());
    }


    @Test
    void testCannotWithdrawFractionalAmount() {
        subject.deposit(1, date);
        assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(0.001, date);
        });
    }

    // Transaction History
    @Test
    void testInitialisedWithEmptyTransactionHistory() {
        assertEquals(0, subject.getTransactions().size());
    }

    @Test
    void testHasATransactionHistory() {
        subject.deposit(1, date);
        subject.withdraw(1, date);
        // Test that the transactions are stored
        assertEquals(2, subject.getTransactions().size());
    }

    // generate statement
    @Test
    void testGeneratesStatement() {
        String result = "date || credit || debit || balance\n01/01/2021 || 1000.00 || - || 1000.00\n01/01/2021 || - || 2.00 || 998.00\n";
        subject.deposit(1000, date);
        subject.withdraw(2, date);

        assertEquals(result, subject.generateStatement());
    }

}
