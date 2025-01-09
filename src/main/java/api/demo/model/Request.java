package api.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Requests")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ticketId;

    Long employeeId;

    Long userId;

    @NotBlank
    @Size(min = 1,max = 50)
    String description;

    String status;

    LocalDateTime dateCreated;

    LocalDateTime closeDate;
}
