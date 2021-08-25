import org.junit.jupiter.api.Test;
import tech.makers.bank.Transaction;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    void testHasADateWhenInitialised() {
        Transaction subject = new Transaction(1);
        LocalDate currentDate = LocalDate.now();
        assertEquals(currentDate, subject.getDate());
        // perhaps statement should parse the date in the correct format
    }

    @Test
    void testHasARunningBalance() {
        Transaction subject = new Transaction(2000);
        assertEquals(2000, subject.getRunningBalance());
    }

}
