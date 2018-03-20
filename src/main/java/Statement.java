import java.math.BigInteger;
import java.time.LocalDate;

public class Statement {
    int amount;
    private LocalDate date;

    public Statement(int change, LocalDate date) {
        amount = change;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        return amount == statement.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
