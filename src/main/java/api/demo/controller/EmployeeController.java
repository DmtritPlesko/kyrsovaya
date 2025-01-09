package api.demo.controller;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;
import api.demo.service.employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/crud/employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeController {

    final EmployeeService employeeService;

    @GetMapping
    public List<ShortEmployeeDto> getAllEmployees() {

        return List.of();
    }

    @PostMapping
    public ShortEmployeeDto addNewEmployee (@Valid @RequestBody FullEmployeeDto employeeDto) {

        return new ShortEmployeeDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee (@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
