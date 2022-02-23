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

    public static Account createAccount(String type, int id, BigDecimal balance, Currency currency) {
        if (type.equals("Savings")){
            return new SavingsAccount(id,balance,currency);
        }else if (type.equals("Youth")){
            return new YouthAccount(id,balance,currency);
        }
        return null;
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
