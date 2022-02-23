import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accountList;
    //builder płeć wiek pesel miasto zamieszkania nip

    private Client(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountList = new ArrayList<>();
    }

    //factory pattern
    public static Client createClient (int id, String firstName, String lastName) {
        return  new Client(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
