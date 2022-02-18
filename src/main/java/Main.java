import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(1, "Adam", "Bosak", new ArrayList<>());
        Client client1 = new Client(1, "Agata", "Kowalska", new ArrayList<>());
        Client client2 = new Client(1, "Adrian", "Boski", new ArrayList<>());
        Client client3 = new Client(1, "Daria", "Mędrek", new ArrayList<>());

        BankService bankService = new BankService();
        bankService.addClient(client);
        bankService.addClient(client1);
        bankService.addClient(client2);
        bankService.addClient(client3);


        ClientService clientService = new ClientService();

        clientService.createAccount(client, "PLN");
        clientService.createAccount(client, "USD");
        clientService.createAccount(client3,"USD");
        System.out.println(client);
        System.out.println(client3);
        clientService.deleteAccount(client, 1);
        System.out.println(client);

        for (int i = 0; i < 10; i++) {
            clientService.createAccount(client, "PLN");
        }
        clientService.deleteAccount(client, 599);
        System.out.println(client);
        System.out.println(client.getAccountList().size());

        clientService.deposit(client,new BigDecimal(200),2);
        clientService.deposit(client,new BigDecimal(300),3);
        clientService.deposit(client,new BigDecimal(20000),10);
        clientService.deposit(client,new BigDecimal(200),1);
        System.out.println(client.getAccountList());

        clientService.cashout(client,new BigDecimal(5000),10);
        clientService.cashout(client,new BigDecimal(5000),1);
        clientService.cashout(client,new BigDecimal(3000),2);
        System.out.println(client.getAccountList());



    }
}
