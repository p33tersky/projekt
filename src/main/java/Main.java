import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(1, "Adam", "Bosak", new ArrayList<>());
        Client client1 = new Client(2, "Agata", "Kowalska", new ArrayList<>());
        Client client2 = new Client(3, "Adrian", "Boski", new ArrayList<>());
        Client client3 = new Client(4, "Daria", "Mędrek", new ArrayList<>());

        CurrencyService currencyService = new CurrencyService();


        BankService bankService = new BankService();
        bankService.addClient(client);
        bankService.addClient(client2);
        bankService.addClient(client3);

        System.out.println(client);
        ClientService clientService = new ClientService();
        Account account1 = clientService.createAccount(Currency.USD);

        clientService.addAccountToClient(client, account1);
        System.out.println(client);

        clientService.deposit(client, new BigDecimal(300), 1);
        System.out.println(client);
        clientService.cashOut(client, new BigDecimal(400), 10);
        clientService.cashOut(client, new BigDecimal(100), 1);
        clientService.cashOut(client, new BigDecimal(700), 1);
        System.out.println(client);

        System.out.println(currencyService.convert(BigDecimal.valueOf(1000),Currency.GBP,Currency.EUR));
        System.out.println(currencyService.convert(BigDecimal.valueOf(300),Currency.USD,Currency.EUR));
        System.out.println(currencyService.convert(BigDecimal.valueOf(10),Currency.PLN,Currency.USD));

    }
}
