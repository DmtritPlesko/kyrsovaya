package api.demo.service.answer;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import java.util.List;

public interface AnswerService {

    List<ShortAnswerDto> getAllAnswers();

    ShortAnswerDto getAnsById(Long id);

    FullAnswerDto getByIdDto(Long id);

    ShortAnswerDto addNewAnswer(FullAnswerDto answerDto);

    void deleteAnswer(Long id);
}
