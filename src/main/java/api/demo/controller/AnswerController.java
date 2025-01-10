package api.demo.controller;

import api.demo.dto.answer.FullAnswerDto;
import api.demo.dto.answer.ShortAnswerDto;
import api.demo.service.answer.AnswerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/answer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerController {

    final AnswerService answerService;
    Long ID;

    @GetMapping
    public String getAllAnswers (Model model) {
        List<ShortAnswerDto> shortAnswerDtos = answerService.getAllAnswers();
        log.info(shortAnswerDtos.toString());
        model.addAttribute("answers",shortAnswerDtos);
        return "answers";
    }

    @GetMapping(path = "/{id:\\d+}")
    public String getAnsById(@PathVariable("id") Long id,Model model) {
        model.addAttribute("answer",answerService.getAnsById(id));
        return "answer";
    }

    @PostMapping("/add-answers")
    public String addNewAnswer(@Valid @ModelAttribute("fullAnswerDto") FullAnswerDto fullAnswerDto) {
        answerService.addNewAnswer(fullAnswerDto);
        // Обработка данных формы
        return "redirect:/answer";
    }


    @GetMapping(path = "/add-answers")
    public String showAddingForm(Model model) {
        model.addAttribute("fullAnswerDto",new FullAnswerDto());
        return "add-answers";
    }


    @PostMapping(path = "/delete/{id}")
    public String deleteAnswer() {
        answerService.deleteAnswer(ID);
        return "redirect:/answer";
    }
    @GetMapping(path = "/delete/{id}")
    public String showDeleteForm(@PathVariable Long id,Model model) {
        ID = id;
        model.addAttribute("fullAnswerDto",answerService.getByIdDto(id));
        return "delete-answer";
    }


}
