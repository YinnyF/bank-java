import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.makers.bank.Transaction;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    @Test
    void testHasADateWhenInitialised() {
        Transaction subject = new Transaction();
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        assertEquals(currentDate, subject.getDate());
        // perhaps statement should parse the date in the correct format
    }

}
