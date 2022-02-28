import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ClientService {
    private static Integer accountNumber = 1;


    public Account createAccount(String type, Currency currency) { //SRP - single responsibility
        return Account.createAccount(type,accountNumber, BigDecimal.ZERO, currency);
    }

    public void addAccountToClient(Client client, Account account) {
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

    public void deposit(Client client, BigDecimal amount, int accountId) {

        Optional<Account> searchedAccount = client.getAccountList().stream()
                .filter(t -> t.getId() == accountId)
                .findAny(); //ifPresent

        if (searchedAccount.isEmpty()) {
            System.out.println("Konto o podanym ID nie istnieje");
        } else {
            searchedAccount.get().setBalance(searchedAccount.get().getBalance().add(amount));
            System.out.println("Na konto o numerze " + accountId + " przelano " + amount + " " + searchedAccount.get().getCurrency().getName());
        }

    }

    public void cashOut(Client client, BigDecimal amount, int accountId){
        Optional<Account> searchedAccount = client.getAccountList().stream()
                .filter(t -> t.getId() == accountId)
                .findAny();

        if (searchedAccount.isEmpty()) {
            System.out.println("Konto o podanym ID nie istnieje");
        } else {
            if(searchedAccount.get().getBalance().compareTo(amount)>=0){
                searchedAccount.get().setBalance(searchedAccount.get().getBalance().subtract(amount));
                System.out.println("Z konta o numerze" + accountId + " wypłacono " + amount);
            }
            else {
                System.out.println("Brak hajsu, elo");
            }
        }
    }



//    public BigDecimal convert (BigDecimal amountToExchange, Currency currencyToExchange, Currency currencyToGet){
//        double exchange = currencyToExchange.getExchangeToPLN()/currencyToGet.getExchangeToPLN();
//        return amountToExchange.multiply(BigDecimal.valueOf(exchange));
//    }

    // 1 pln -> 1/4.55 eur
    // 1 usd -> 4.02 pln
    // 1 usd -> 4.02 * 1/4.55 = 4.02/4.55


}
