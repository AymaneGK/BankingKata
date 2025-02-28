package bankkata;

import java.util.LinkedList;
import java.util.List;

public class StatementPrinter {
    private Console console;
    private final static String HEADER = "DATE | AMOUNT | BALANCE";

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLn(HEADER);

        int balance = 0;
        List<String> statementLines = new LinkedList<>();

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            statementLines.add(formatRow(transaction, balance));
        }

        for (int i = statementLines.size() - 1; i >= 0; i--) {
            console.printLn(statementLines.get(i));
        }
    }

    private String formatRow(Transaction transaction, int balance) {
        return transaction.getDate() + " | " + transaction.getAmount() + " | " + balance;
    }
}
