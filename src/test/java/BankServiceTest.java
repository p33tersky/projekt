import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {
    Bank bank;
    BankService bankService;

    @BeforeEach
    public void setUp() {
        bank = new Bank(new HashSet<>());
        bankService = new BankService();
        Client client = new Client(69, "Piotr", "Włostek", new ArrayList<>());
        bank.getClients().add(client);
    }

    @Test
    void addClient() {
        //GIVEN
        int currentSize = bank.getClients().size();
        //WHEN
        bankService.addClient(new Client(2, "Daria", "Mędrek", new ArrayList<>()));
        //THEN
        int newCurrentSize = bank.getClients().size();
        Assertions.assertThat(newCurrentSize).as("Test failure").isEqualTo(currentSize + 1);
    }

    @Test
    void removeClient() {
    }
}