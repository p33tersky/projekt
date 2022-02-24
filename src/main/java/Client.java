import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private boolean isMale;
    private short age;
    private String nationality;
    private List<Account> accountList;
    //builder płeć wiek pesel miasto zamieszkania nip

    //builder
    private Client(ClientBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.isMale = builder.isMale;
        this.age = builder.age;
        this.nationality = builder.nationality;
        this.accountList = builder.accountList;
    }

    //konstruktor dla factory
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
    //DTO


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    public static  class ClientBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private boolean isMale;
        private short age;
        private String nationality;
        private List<Account> accountList;

        public ClientBuilder(final int id, final String firstName, final String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.accountList = new ArrayList<>();
        }

        public ClientBuilder withIsMale(final Boolean isMale) {
            this.isMale = isMale;
            return this;
        }

        public ClientBuilder withAge(final short age) {
            this.age = age;
            return this;
        }

        public ClientBuilder withNationality(final String nationality) {
            this.nationality = nationality;
            return this;
        }
        public Client build () {
            return new Client(this);
        }


    }
}
