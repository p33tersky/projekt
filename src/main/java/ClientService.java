import java.math.BigDecimal;
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
        int checker = 0;
        for (int i = 0; i < client.getAccountList().size(); i++) {
            if (client.getAccountList().get(i).getId() == accountIdToDelete){
              checker++;
                System.out.println("Usuwam konto o id " + accountIdToDelete);
                client.getAccountList().remove(i);
            }
        }
        if (checker == 0) {
            System.out.println("Nie ma konta o podanym id: " + accountIdToDelete);
        }
//        Optional<Integer> id = client.getAccountList().stream()
//                .map(Account::getId)
//                .filter(t -> t.equals(accountIdToDelete))
//                .findAny();
//        client.getAccountList().remove(accountIdToDelete);
//        System.out.println(id);

//        Optional <Account> accountToDelete = client.getAccountList().stream()
//                .filter(t -> t.getId() == accountIdToDelete)
//                .findAny();

//        client.getAccountList().remove(accountToDelete);
//        System.out.println(accountToDelete);

    }


    public void deposit(Client client, BigDecimal amount, int id) {
        int checker = 0;
        for (int i = 0; i < client.getAccountList().size(); i++) {
            if (client.getAccountList().get(i).getId() == id){
                checker++;
                BigDecimal cash = client.getAccountList().get(i).getBalance();
                client.getAccountList().get(i).setBalance(cash.add(amount));
                System.out.println("Na konto o id " + id + " wpłcam " + amount);
            }
        }
        if (checker == 0) {
            System.out.println("Nie ma konta o podanym id: " + id);
        }
    }

    public void cashout(Client client, BigDecimal amount, int id){
        int checker = 0;
        for (int i = 0; i < client.getAccountList().size(); i++) {
            if (client.getAccountList().get(i).getId() == id){
                checker++;
                BigDecimal cash = client.getAccountList().get(i).getBalance();
                if (client.getAccountList().get(i).getBalance().compareTo(amount) >= 0){
                    client.getAccountList().get(i).setBalance(cash.subtract(amount));
                    System.out.println("Z konta o id " + id + " wypłacam " + amount);
                } else {
                    System.out.println("Brak środków do wypłaty z podanego konta ");
                }
                System.out.println("Stan konta o id: " + id + " wynosi " + client.getAccountList().get(i).getBalance());
            }
        }
        if (checker == 0) {
            System.out.println("Nie ma konta o podanym id: " + id);
        }

    }


}
