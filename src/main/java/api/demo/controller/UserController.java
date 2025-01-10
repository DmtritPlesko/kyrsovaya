package api.demo.controller;

import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;
import api.demo.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;
    Long ID;

    @GetMapping
    public String getAllUsers(Model model) {
        List<ShortUserDto> userDtos = userService.getAllUsers();
        model.addAttribute("users", userDtos);
        return "users"; // Имя шаблона
    }

    @GetMapping(path = "/{id}")
    public String getByID(@PathVariable Long id,Model model) {
        model.addAttribute("user",userService.getById(id));
        return "user";
    }

    @PostMapping(path = "/add-user")
    public String addUser(@Valid @ModelAttribute("fullUserDto") FullUserDto user) {
        userService.addNewUser(user);
        return "redirect:/user";
    }
    @GetMapping(path = "/add-user")
    public String showAddingForm(Model model) {

        model.addAttribute("fullUserDto",new FullUserDto());
        return "add-user";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteUser() {
        userService.deleteUser(ID);

        return "redirect:/user";
    }
    @GetMapping(path ="/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id,Model model) {
        ID=id;
        model.addAttribute("fullUserDto",userService.getByIdFullDto(id));

        return "delete-user";
    }
}
