import java.math.BigDecimal;
import java.util.List;

public class Account {
    private int id;
    private BigDecimal balance;
    private Currency currency;

    public Account(int id, BigDecimal balance, Currency currency) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id_account=" + id +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
