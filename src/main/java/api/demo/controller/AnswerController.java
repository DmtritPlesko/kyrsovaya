package api.demo.controller;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import api.demo.service.answer.AnswerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/crud/answer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerController {

    final AnswerService answerService;

    @GetMapping
    public List<ShortAnswerDto> getAllAnswers () {

        return answerService.getAllAnswers();
    }

    @PostMapping
    public ShortAnswerDto addNewAnswer(@Valid @RequestBody FullAnswerDto answerDto) {

        return answerService.addNewAnswer(answerDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
    }
}
