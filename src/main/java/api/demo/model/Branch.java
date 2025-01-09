package api.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "Branches")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long branchId;

    @NotBlank
    @Size(min = 1,max = 20)
    String name;

    @NotBlank
    @Size(min = 1,max = 50)
    String address;

    @NotBlank
    @Size(min = 1,max = 11)
    String phone;

    public Branch (Long id, String name) {
        this.branchId = id;
        this.name = name;
    }

}
