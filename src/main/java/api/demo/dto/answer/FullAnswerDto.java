package api.demo.dto.answer;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullAnswerDto {

    Long employeeId;

    String description;

    LocalDateTime dataOfResponse;

    public FullAnswerDto(String description) {
        this.description = description;
    }
}
