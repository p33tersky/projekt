import java.util.Set;

public class Bank {

    private Set<Client> clients;

    public Bank(Set<Client> clients) {

        this.clients = clients;
    }

    public Set<Client> getClients() {

        return clients;
    }

    public void setClients(Set<Client> clients) {

        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "clients=" + clients +
                '}';
    }

}
