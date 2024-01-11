package savogineros.AppuntiBackendu2w1d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String surname;
    private String email;
    private int age;


    // COSTRUTTORE (oltre a quello vuoto generato con @NoArgsConstructor, richiesto per i database)
    public User(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }
}
