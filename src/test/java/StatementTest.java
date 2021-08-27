import org.junit.jupiter.api.Test;
import tech.makers.bank.Statement;
import tech.makers.bank.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {
    private final String header = "date || credit || debit || balance\n";

    @Test
    void testCanReturnTheHeader() {
        Statement subject = new Statement();
        assertEquals(header, subject.print());
    }

    @Test
    void testCanReturnTheStatementWhenGivenATransaction() {
        Statement subject = new Statement();

        LocalDate date = LocalDate.of(2021, 1, 1);
        Transaction transaction = new Transaction(date, 1, 0, 1);

        ArrayList<Transaction> transactions = new ArrayList();
        transactions.add(transaction);

        String output = "date || credit || debit || balance\n01/01/2021 || 1.00 || - || 1.00\n";
        assertEquals(output, subject.print(transactions));
    }
}
