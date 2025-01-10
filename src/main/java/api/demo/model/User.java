package api.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Size(min = 1, max = 20)
    String name;

    @Email(message = "Неверный формат почты")
    String email;

    @Size(max = 11)
    String phoneNumber;

    public User (Long id,String name) {
        this.userId = id;
        this.name = name;
    }
}
