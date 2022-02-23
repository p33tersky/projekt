import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private final BigDecimal interestRate = new BigDecimal("0.04");

    public SavingsAccount(int id, BigDecimal balance, Currency currency) {
        super(id, balance, currency);
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
