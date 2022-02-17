import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
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
