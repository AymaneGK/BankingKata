package bankkata;

public class Account implements AccountService{
    private TransactionRepo transactionRepo;
    private StatementPrinter statementPrinter;
    public Account(TransactionRepo transactionRepo, StatementPrinter statementPrinter){
        this.transactionRepo = transactionRepo;
        this.statementPrinter = statementPrinter;
    }
    @Override
    public void deposit(int amount) {
       transactionRepo.addDeposit(amount);

    }

    @Override
    public void withdraw(int amount) {
        transactionRepo.addWithdraw(amount);
    }

    @Override
    public void printStatement() {
        statementPrinter.print(transactionRepo.getAllTransactions());
    }


}
