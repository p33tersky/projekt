import lombok.Data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;

@Data
public class BankService {
    private Bank bank = new Bank(new HashSet<>());


    public void addClient (Client client) {
        bank.getClients().add(client);
        System.out.println(client.getFirstName() + " " + client.getLastName() + " nowym klientem naszego banku!");
    }

    public void removeClient (Client client) {
        bank.getClients().remove(client);
        System.out.println(client.getFirstName() + " " + client.getLastName() + " narazie, elo, naura");
    }


}
