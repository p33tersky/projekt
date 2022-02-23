import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyService {
    public BigDecimal convert(BigDecimal amountToExchange, Currency currencyToExchange, Currency currencyToGet) {
        double exchange = currencyToExchange.getExchangeToPLN() / currencyToGet.getExchangeToPLN();
        return amountToExchange.multiply(BigDecimal.valueOf(exchange)).setScale(2, RoundingMode.HALF_DOWN);
    }
}

