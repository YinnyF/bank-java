import org.junit.jupiter.api.Test;
import tech.makers.bank.Transaction;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    private final LocalDate date = LocalDate.of(2021, 1, 1);

    @Test
    void testHasADateWhenInitialised() {
        Transaction subject = new Transaction(date, 0, 0, 1);
        assertEquals(date, subject.getDate());
        // perhaps statement should parse the date in the correct format
    }

    @Test
    void testHasARunningBalance() {
        Transaction subject = new Transaction(date, 0, 0, 2000);
        assertEquals(2000, subject.getRunningBalance());
    }

    @Test
    void testCanHaveADebitAmount() {
        Transaction subject = new Transaction(date, 0, 1, 2000);
        assertEquals(1, subject.getDebit());
    }

    @Test
    void testCanHaveACreditAmount() {
        Transaction subject = new Transaction(date, 1, 0, 2000);
        assertEquals(1, subject.getCredit());
    }
}
