import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.makers.bank.BankAccount;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testCannotWithdrawFractionalAmount() {
        subject.deposit(1, date);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(0.001f, date);
        });
    }
}
