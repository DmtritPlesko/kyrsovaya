package api.demo.service.employee;
import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<ShortEmployeeDto> getAllEmployees();

    ShortEmployeeDto addNewEmployee(FullEmployeeDto employeeDto);

    void deleteEmployee(Long id);
}
