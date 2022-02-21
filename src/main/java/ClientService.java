import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ClientService {
    private static Integer accountNumber = 1;

    public void createAccount(Client client, String currency) {

        Account account = new Account(accountNumber, new BigDecimal(0), currency );
        client.getAccountList().add(account);
        System.out.println("Dodano konto klienta o imieniu " + client.getFirstName() + " o numerze " + accountNumber);
        accountNumber++;
    }

    public void deleteAccount(Client client, int accountIdToDelete) {  //forEach lub stream, optional

        boolean isRemoved = client.getAccountList().removeIf(t -> t.getId() == accountIdToDelete);
        if (isRemoved) {
            System.out.println("Usunięto konto o ID " + accountIdToDelete);
        } else {
            System.out.println("Konto o podanym ID nie istnieje");
        }

    }

    public void deposit(Client client, BigDecimal amount, int id) {

        Optional<Account> searchedAccount = client.getAccountList().stream()
                .filter(t -> t.getId() == id)
                .findAny();

        if (searchedAccount.isEmpty()) {
            System.out.println("Konto o podanym ID nie istnieje");
        } else {
            searchedAccount.get().setBalance(searchedAccount.get().getBalance().add(amount));
            System.out.println("Na konto o numerze " + id + " przelano " + amount);
        }
//        client.getAccountList().stream().filter(a ->
//             a.getId()==id
//        ).findAny().ifPresent(a-> {
//            BigDecimal cash = client.getAccountList().get().getBalance();
//            client.getAccountList().get(id).setBalance(cash.add(amount));
//        });
    }

    public void cashout(Client client, BigDecimal amount, int id){
        Optional<Account> searchedAccount = client.getAccountList().stream()
                .filter(t -> t.getId() == id)
                .findAny();

        if (searchedAccount.isEmpty()) {
            System.out.println("Konto o podanym ID nie istnieje");
        } else {
            searchedAccount.get().setBalance(searchedAccount.get().getBalance().subtract(amount));
            System.out.println("Z konta o numerze" + id + " wypłacono " + amount);
        }
    }

}
