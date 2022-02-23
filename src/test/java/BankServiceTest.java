import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;

class BankServiceTest {
    Bank bank;
    BankService bankService;
    Client client;

    @BeforeEach
    public void setUp() {
        bankService = new BankService();
        bank = new Bank(new HashSet<>());
        client = Client.createClient(1, "Piotr", "Włostek");
        bankService.setBank(bank);
        bankService.getBank().getClients().add(client);
    }

    @Test
    void addClient() {
        //GIVEN
        int currentSize = bank.getClients().size();
        //WHEN
        bankService.addClient(Client.createClient(2, "Daria", "Mędrek"));
        //THEN
        int newCurrentSize = bank.getClients().size();
        Assertions.assertThat(newCurrentSize).as("Test failure").isEqualTo(currentSize + 1);
    }

    @Test
    void removeClient() {
        //GIVEN
        int currentSize = bank.getClients().size();
        //WHEN
        bankService.removeClient(client);
        //THEN
        int newCurrentSize = bank.getClients().size();
        Assertions.assertThat(newCurrentSize).as("Test failure").isEqualTo(currentSize - 1);
    }

}