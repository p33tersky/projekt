import lombok.Data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Optional;

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

    public Optional<Account> findAccountById(int id){
        Optional<Account> account = bank.getClients().stream()
                .flatMap(t -> t.getAccountList().stream())
                .filter(t -> t.getId() == id)
                .findAny();
        if(account.isEmpty()){
            System.out.println("Konto o podanym id nie istnieje");
        }
        return account;

    }
}
