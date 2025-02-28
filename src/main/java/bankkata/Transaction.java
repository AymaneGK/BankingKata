package bankkata;

import java.util.Objects;

public class Transaction {
    private final int amount;
    private final String date;

    public Transaction(int amount, String s) {
        this.amount = amount;
        this.date = s;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
