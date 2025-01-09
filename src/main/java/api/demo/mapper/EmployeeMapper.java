package api.demo.mapper;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;
import api.demo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public ShortEmployeeDto toShortEmployeeDto(Employee employee) {
        ShortEmployeeDto employeeDto = new ShortEmployeeDto();

        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setName(employee.getName());
        employeeDto.setTitle(employeeDto.getTitle());

        return employeeDto;
    }

    public Employee toEmployee(FullEmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setName(employeeDto.getName());
        employee.setTitle(employeeDto.getTitle());
        employee.setAvailability(employeeDto.getAvailability());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());

        return employee;
    }
}
