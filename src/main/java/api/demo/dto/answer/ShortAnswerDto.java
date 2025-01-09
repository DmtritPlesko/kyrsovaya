package api.demo.dto.answer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class ShortAnswerDto {
    Long id;

    String description;

    public ShortAnswerDto (String description) {
        this.description = description;
    }
    public ShortAnswerDto () {

    }
}
