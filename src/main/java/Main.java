import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Client client = Client.createClient(1, "Adam", "Bosak");
        Client client1 =Client.createClient(2, "Agata", "Kowalska");
        Client client2 =Client.createClient(3, "Adrian", "Boski");
        Client client3 =Client.createClient(4, "Daria", "Mędrek");

        CurrencyService currencyService = new CurrencyService();


        BankService bankService = new BankService();
        bankService.addClient(client);
        bankService.addClient(client2);
        bankService.addClient(client3);

        System.out.println(client);
        ClientService clientService = new ClientService();
        Account account1 = clientService.createAccount("Youth", Currency.PLN);
        Account account2 = Account.createAccount("Savings", 99, BigDecimal.ZERO, Currency.EUR);


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

        System.out.println(account2);
        System.out.println(((SavingsAccount) account2).getInterestRate());

        Client client5 = new Client.ClientBuilder(39, "john","Szybki")
                .withAge((short) 21)
                .withIsMale(true)
                .build();
        System.out.println(client5);

    }
}
