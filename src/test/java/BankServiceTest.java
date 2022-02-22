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
        bankService = new BankService();
        bank = new Bank(new HashSet<>());
        Client client = new Client(1, "Piotr", "Włostek", new ArrayList<>());
        bankService.setBank(bank);
        bankService.getBank().getClients().add(client);
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
        //GIVEN
        int currentSize = bank.getClients().size();
        //WHEN
        bankService.addClient(new Client(2, "Daria", "Mędrek", new ArrayList<>()));
        //THEN
        int newCurrentSize = bank.getClients().size();
        Assertions.assertThat(newCurrentSize).as("Test failure").isEqualTo(currentSize - 1);
    }
}