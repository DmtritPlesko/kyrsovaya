package api.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Answers")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long answerId;

    Long employeeId;

    @NotBlank
    @Size(min = 1,max = 50)
    String description;

    LocalDateTime dataOfResponse;

    public Answer (Long id,String description) {
        this.answerId  = id;
        this.description = description;
    }
}
