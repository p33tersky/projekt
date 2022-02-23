import lombok.Data;

import java.util.List;

@Data
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accountList;

    public Client(int id, String firstName, String lastName, List<Account> list) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountList = list;
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
