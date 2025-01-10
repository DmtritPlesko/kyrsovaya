package api.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@Entity
@Table(name = "Employees")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;

    @NotBlank
    @Size(min = 1,max = 20)
    String name;

    @NotBlank
    @Size(max = 11)
    String phoneNumber;

    @NotBlank
    @Size(min = 1,max = 50)
    String title;

    Boolean availability;

    public Employee(Long id,String name) {
        this.employeeId = id;
        this.name = name;
    }
}
