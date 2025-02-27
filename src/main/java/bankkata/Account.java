package bankkata;

public class Account implements AccountService{
    private TransactionRepo transactionRepo;
    public Account(TransactionRepo transactionRepo){
        throw new UnsupportedOperationException();
    }
    @Override
    public void deposit(int amount) {
       // throw new UnsupportedOperationException();

    }

    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void printStatement() {

        throw new UnsupportedOperationException();

    }


}
