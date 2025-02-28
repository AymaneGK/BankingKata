package requirements;

import bankkata.Console;
import bankkata.StatementPrinter;
import bankkata.TodayDateProvider;
import bankkata.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
    private static final List<Transaction> transactionList = new ArrayList<>(); //empty
    @Mock Console console;

    @Test
    public void printHeader(){
        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.print(transactionList);
        verify(console).printLn("DATE | AMOUNT | BALANCE");
    }
    @Test
    public void printInReverseOrder(){
        StatementPrinter statementPrinter = new StatementPrinter(console);
        List<Transaction> list = new ArrayList<>();
        deposit(1000,list, "10/01/2012");
        deposit(2000,list, "13/01/2012");
        withdraw(500,list, "14/01/2012");
        statementPrinter.print(list);

        InOrder order = inOrder(console);
        order.verify(console).printLn("DATE | AMOUNT | BALANCE");
        order.verify(console).printLn("14/01/2012 | -500 | 2500");
        order.verify(console).printLn("13/01/2012 | 2000 | 3000");
        order.verify(console).printLn("10/01/2012 | 1000 | 1000");
    }
    public void deposit(int amount, List<Transaction> transactionList, String date){
        Transaction t = new Transaction(amount,date);
        transactionList.add(t);
    }
    public void withdraw(int amount, List<Transaction> transactionList, String date){
        Transaction t = new Transaction(-amount,date);
        transactionList.add(t);
    }
}
