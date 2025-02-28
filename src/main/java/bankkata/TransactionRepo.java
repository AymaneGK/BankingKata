package bankkata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TransactionRepo {
    private final TodayDateProvider todayDateProvider;
    private List<Transaction> transactionList= new ArrayList<>();

    public TransactionRepo(TodayDateProvider todayDateProvider) {
        this.todayDateProvider = todayDateProvider;
    }

    public void addDeposit(int amount){
        transactionList.add(new Transaction(amount,todayDateProvider.todayString()));
    }
    public void addWithdraw(int amount){
        transactionList.add(new Transaction(-amount,todayDateProvider.todayString()));
    }
    public void printStatement(){
        throw new UnsupportedOperationException();
    }
    public List<Transaction> getAllTransactions(){
        return Collections.unmodifiableList(transactionList);

    }
}
