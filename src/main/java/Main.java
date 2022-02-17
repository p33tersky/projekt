import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(1, "a", "b", new ArrayList<>());

        ClientService clientService = new ClientService();

        clientService.createAccount(client, "PLN");
        clientService.createAccount(client, "USD");
        System.out.println(client);
        clientService.deleteAccount(client, 1);
        System.out.println(client);

        for (int i = 0; i < 100; i++) {
            clientService.createAccount(client, "PLN");
        }
        clientService.deleteAccount(client, 68);
        System.out.println(client);

//        clientService.deposit(client, new BigDecimal(100), 0);
//        System.out.println(client);



    }
}
