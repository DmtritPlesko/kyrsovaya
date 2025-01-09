package api.demo.dto.answer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FullAnswerDto {

    Long answerId;

    Long employeeId;

    String description;

    LocalDateTime dataOfResponse;

    public FullAnswerDto(String description) {
        this.description = description;
    }
}
