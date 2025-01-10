package api.demo.controller;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;
import api.demo.service.employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeController {

    final EmployeeService employeeService;
    Long ID;

    @GetMapping
    public String getAllEmployees(Model model) {

        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping(path = "/{id}")
    public String getEmplById(@PathVariable("id") Long id,Model model) {
        model.addAttribute("employee",employeeService.getEmplByID(id));
        log.info(employeeService.getEmplByID(id).toString());
        return "employee";
    }

    @PostMapping(path = "/add-employee")
    public String addNewEmployee (@Valid @ModelAttribute("fullEmployeeDto") FullEmployeeDto fullEmployeeDto) {

        employeeService.addNewEmployee(fullEmployeeDto);
        return "redirect:/employee";
    }
    @GetMapping(path = "/add-employee")
    public String showAddingForm(Model model) {

        model.addAttribute("fullEmployeeDto",new FullEmployeeDto());
        return "add-employee";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteEmployee () {
        employeeService.deleteEmployee(ID);
        return "redirect:/employee";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm (@PathVariable("id") Long id,Model model) {
        ID=id;
        model.addAttribute("fullEmployeeDto",employeeService.getBuIdDto(id));

        return "delete-employee";
    }
}
