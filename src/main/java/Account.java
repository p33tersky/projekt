import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Account {
    private int id;
    private BigDecimal balance;
    private Currency currency;

    public Account(int id, BigDecimal balance, Currency currency) {
        this.id = id;
        this.balance = balance;
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
