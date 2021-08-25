import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.makers.bank.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    private final BankAccount subject = new BankAccount();

    // Initial balance
    @Test
    void testHasStartingBalanceZero() {
        assertEquals(0, subject.getBalance());
    }

    // Depositing
    @Test
    void testDeposit() {
        subject.deposit(1);
        assertEquals(1, subject.getBalance());
    }

    @Test
    void testCannotDepositNegativeAmount() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.deposit(-1);
        });
    }

    @Test
    void testCannotDepositFractionalPennies() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.deposit(0.001f);
        });
    }

    // Withdrawals
    @Test
    void testWithdrawal() {
        subject.deposit(1);
        subject.withdraw(1);
        assertEquals(0, subject.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanBalance() {
        subject.deposit(1);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(2);
        });
    }

    @Test
    void testCannotWithdrawNegativeAmount() {
        subject.deposit(1);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(-1);
        });
    }

    @Test
    void testCannotWithdrawFractionalAmount() {
        subject.deposit(1);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            subject.withdraw(0.001f);
        });
    }
}
