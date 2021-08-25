import org.junit.jupiter.api.Test;
import tech.makers.bank.Statement;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {
    private final String header = "date || credit || debit || balance\n";

    @Test
    void testCanReturnTheHeader() {
        Statement subject = new Statement();
        assertEquals(header, subject.print());
    }
}
