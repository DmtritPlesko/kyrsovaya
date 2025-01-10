package api.demo.controller;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.request.FullRequestDto;
import api.demo.dto.request.ShortRequestDto;
import api.demo.service.request.RequestService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/request")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestController {

    final RequestService requestService;
    Long ID;

    @GetMapping
    public String getAllRequests(Model model) {
        model.addAttribute("requests",requestService.getAllRequests());
        return "requests";
    }

    @GetMapping(path = "/{id}")
    public String getReqByID(@PathVariable("id")Long id, Model model) {
        model.addAttribute("request",requestService.getReqById(id));
        return "request";
    }

    @PostMapping("/add-request")
    public String addNewRequest(@Valid @ModelAttribute("fullRequestDto") FullRequestDto fullRequestDto) {
        requestService.addNewRequest(fullRequestDto);
        return "redirect:/request";
    }

    @GetMapping(path = "/add-request")
    public String showAddingForm(Model model ) {
        model.addAttribute("fullRequestDto",new FullRequestDto());
        return "add-request";
    }


    @PostMapping("/delete/{id}")
    public String deleteRequest() {
        requestService.deleteRequest(ID);
        return "redirect:/request";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id,Model model) {
        ID=id;
        model.addAttribute("fullRequestDto",requestService.getByIdDto(id));
        return "delete-request";
    }
}
