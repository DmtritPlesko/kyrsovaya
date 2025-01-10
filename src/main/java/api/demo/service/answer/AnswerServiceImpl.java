package api.demo.service.answer;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import api.demo.mapper.AnswerMapper;
import api.demo.repository.AnswerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerServiceImpl implements AnswerService{

    final AnswerRepository repository;
    final AnswerMapper answerMapper;

    @Override
    public List<ShortAnswerDto> getAllAnswers() {
        return repository.findAll().stream()
                .map(answerMapper::toShortAnswerDto)
                .toList();
    }

    @Override
    public ShortAnswerDto getAnsById(Long id) {
        return answerMapper.toShortAnswerDto(repository.findById(id).get());
    }

    @Override
    public FullAnswerDto getByIdDto(Long id) {
        return answerMapper.toFullAnswerDto(repository.findById(id).get());
    }

    @Override
    public ShortAnswerDto addNewAnswer(FullAnswerDto answerDto) {
        return answerMapper.toShortAnswerDto(repository.save(answerMapper.toAnswer(answerDto)));
    }

    @Override
    public void deleteAnswer(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Запись Answer c id = " + id + " не существует");
        }

    }
}
