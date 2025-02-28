package requirements;
import bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.text.ParseException;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepoTest {
    private TransactionRepo transactionRepo;
    private static String TODAY = "13/01/2012";

    @Mock
    private TodayDateProvider todayDateProvider;

    @Before
    public void setUp() {
        transactionRepo = new TransactionRepo(todayDateProvider);
    }

    @Test
    public void addDepositTransaction() throws ParseException {
        given(todayDateProvider.todayString()).willReturn(TODAY);
        transactionRepo.addDeposit(1000);

        List<Transaction> transactionList = transactionRepo.getAllTransactions();

        assertEquals(1, transactionList.size());

        Transaction transaction = transactionList.get(0);
        assertEquals(1000, transaction.getAmount());
        assertEquals(TODAY, transaction.getDate());
    }
    @Test
    public void addWithdrawTransaction() throws ParseException {
        given(todayDateProvider.todayString()).willReturn(TODAY);
        transactionRepo.addWithdraw(1000);

        List<Transaction> transactionList = transactionRepo.getAllTransactions();

        assertEquals(1, transactionList.size());

        Transaction transaction = transactionList.get(0);
        assertEquals(-1000, transaction.getAmount());
        assertEquals(TODAY, transaction.getDate());
    }
}
