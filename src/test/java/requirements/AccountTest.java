package requirements;
import bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    Account acc;
    @Mock
    TransactionRepo transactionRepo;
    @Mock
     private StatementPrinter statementPrinter;

    @Before
    public void setUp(){
        this.acc = new Account(transactionRepo, statementPrinter);
    }
    @Test
    public void storeDeposit(){
        acc.deposit(1000);
        verify(transactionRepo).addDeposit(1000);
    }
    @Test
    public void storeWithdraw(){
        acc.withdraw(500);
        verify(transactionRepo).addWithdraw(500);
    }
    @Test
    public void printTransaction(){
        List<Transaction> transactionList = new ArrayList<>();
        Transaction t = new Transaction(1000,"13/01/2012");
        transactionList.add(t);
        given(transactionRepo.getAllTransactions()).willReturn(transactionList);
        acc.printStatement();
        verify(statementPrinter).print(transactionList);
    }
}
