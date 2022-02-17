import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ClientService {
    private static Integer accountNumber = 0;

    public void createAccount(Client client, String currency) {

        Account account = new Account(accountNumber, new BigDecimal(0), currency );
        client.getAccountList().add(account);
        System.out.println("Dodano konto klienta o imieniu " + client.getFirstName() + "o numerze " + accountNumber);
        accountNumber++;
    }

    public void deleteAccount(Client client, int accountIdToDelete) {  //forEach lub stream, optional
        Optional<Integer> id = client.getAccountList().stream()
                .map(Account::getId)
                .filter(t -> t.equals(accountIdToDelete))
                .findAny();
        client.getAccountList().remove(accountIdToDelete);
        System.out.println(id);

//        Optional <Account> accountToDelete = client.getAccountList().stream()
//                .filter(t -> t.getId() == accountIdToDelete)
//                .findAny();
//
//        client.getAccountList().remove(accountToDelete);
//        System.out.println(accountToDelete);

    }


    public void deposit(Client client, BigDecimal amount, int id) {
        BigDecimal cash = client.getAccountList().get(id).getBalance();
        client.getAccountList().get(id).setBalance(cash.add(amount));
    }


}
