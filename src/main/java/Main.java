import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(1, "Adam", "Bosak", new ArrayList<>());
        Client client1 = new Client(2, "Agata", "Kowalska", new ArrayList<>());
        Client client2 = new Client(3, "Adrian", "Boski", new ArrayList<>());
        Client client3 = new Client(4, "Daria", "Mędrek", new ArrayList<>());


        BankService bankService = new BankService();
        bankService.addClient(client);
        bankService.addClient(client2);
        bankService.addClient(client3);

        System.out.println(client);
        ClientService clientService = new ClientService();
        Account account1 = clientService.createAccount("USD");

        clientService.addAccountToClient(client, account1);
        System.out.println(client);














//        BankService bankService = new BankService();
//        bankService.addClient(client);
//        bankService.addClient(client1);
//        bankService.addClient(client2);
//        bankService.addClient(client3);
//
//
//        ClientService clientService = new ClientService();
//
//        clientService.createAccount(client, "PLN");
//
//        clientService.createAccount(client, "USD");
//        clientService.createAccount(client3,"USD");
//        System.out.println(client);
//        System.out.println(client3);
//        clientService.deleteAccount(client, 1);
//
//
//
//        System.out.println(client);
//        clientService.deposit(client, new BigDecimal(200), 2);
//        System.out.println(client);
//        clientService.cashout(client, new BigDecimal(100), 2);
//        System.out.println(client);


    }
}
