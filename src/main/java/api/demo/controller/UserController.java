package api.demo.controller;

import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;
import api.demo.service.user.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/crud/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @GetMapping
    public List<ShortUserDto> getAllUsers() {
        return List.of();
    }

    @PostMapping
    public ShortUserDto addUser(@Valid @RequestBody FullUserDto user) {

        return new ShortUserDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
