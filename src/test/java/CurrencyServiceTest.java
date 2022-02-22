import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyServiceTest {

    @Test
    void shouldConvertGivenCurrencies() {
        //GIVEN
        CurrencyService currencyService = new CurrencyService();
        Currency usd = Currency.USD;
        Currency pln = Currency.PLN;
        //WHEN
        BigDecimal result = currencyService.convert(BigDecimal.valueOf(100), usd, pln);
        //THEN
        Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(402).setScale(2, RoundingMode.HALF_DOWN));
    }
}