package requirements;
import bankkata.Account;
import bankkata.AccountService;
import bankkata.Console;
import bankkata.TransactionRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    Account acc;
    @Mock
    TransactionRepo transactionRepo;

    @Before
    public void setUp(){
        this.acc = new Account(transactionRepo);
    }
    @Test
    public void storeTransaction(){
        acc.deposit(1000);
        verify(transactionRepo).addDeposit(1000);
    }
}
