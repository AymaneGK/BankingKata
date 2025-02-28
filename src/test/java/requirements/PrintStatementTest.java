package requirements;

import bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementTest {
    @Mock private TodayDateProvider todayDateProvider;
    @Mock Console console= new Console();
    private Account account;

    @Before
    public void setUp() {
        StatementPrinter statementPrinter = new StatementPrinter(console);
        TransactionRepo transactionRepo = new TransactionRepo(todayDateProvider);
        account = new Account(transactionRepo, statementPrinter);
    }

    @Test
    public void shouldPrintAll() {
        given(todayDateProvider.todayString()).willReturn("10/01/2012","13/01/2012","14/01/2012");
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();
        InOrder order = inOrder(console);
        order.verify(console).printLn("DATE | AMOUNT | BALANCE");
        order.verify(console).printLn("14/01/2012 | -500 | 2500");
        order.verify(console).printLn("13/01/2012 | 2000 | 3000");
        order.verify(console).printLn("10/01/2012 | 1000 | 1000");
    }
}
