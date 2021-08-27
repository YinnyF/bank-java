import org.junit.jupiter.api.Test;
import tech.makers.bank.ITransaction;
import tech.makers.bank.Statement;

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

        MockTransaction transaction = new MockTransaction();

        ArrayList<ITransaction> transactions = new ArrayList();
        transactions.add(transaction);

        String output = "date || credit || debit || balance\n01/01/2021 || 1.00 || - || 1.00\n";
        assertEquals(output, subject.print(transactions));
    }

    private class MockTransaction implements ITransaction {
        public LocalDate getDate() {
            return LocalDate.of(2021, 1, 1);
        }

        public double getCredit() {
            return 1;
        }

        public double getDebit() {
            return 0;
        }

        public double getRunningBalance() {
            return 1;
        }
    }
}
