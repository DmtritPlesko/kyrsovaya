package api.demo.mapper;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import api.demo.dto.branch.FullBranchDto;
import api.demo.model.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public ShortAnswerDto toShortAnswerDto(Answer answer) {
        ShortAnswerDto answerDto = new ShortAnswerDto();

        answerDto.setId(answer.getAnswerId());
        answerDto.setDescription(answer.getDescription());

        return answerDto;
    }

    public Answer toAnswer(FullAnswerDto answerDto) {
        Answer answer = new Answer();

        answer.setDescription(answerDto.getDescription());
        answer.setDataOfResponse(answerDto.getDataOfResponse());
        answer.setEmployeeId(answerDto.getEmployeeId());

        return answer;
    }

    public FullAnswerDto toFullAnswerDto(Answer answer) {
        FullAnswerDto fullAnswerDto = new FullAnswerDto();

        fullAnswerDto.setDescription(answer.getDescription());
        fullAnswerDto.setEmployeeId(answer.getEmployeeId());

        return fullAnswerDto;
    }
}
