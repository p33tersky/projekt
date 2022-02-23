import lombok.Data;

import java.math.BigDecimal;

public class YouthAccount extends Account{
    private final BigDecimal interestRate = new BigDecimal("0.1");
    public YouthAccount(int id, BigDecimal balance, Currency currency) {
        super(id, balance, currency);
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }


}
