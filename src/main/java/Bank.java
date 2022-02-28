import lombok.Data;

import java.util.Set;

@Data
public class Bank {

    private Set<Client> clients;

    public Bank(Set<Client> clients) {

        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "clients=" + clients +
                '}';
    }


}
