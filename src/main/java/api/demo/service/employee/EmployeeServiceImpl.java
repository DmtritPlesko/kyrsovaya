package api.demo.service.employee;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;
import api.demo.mapper.EmployeeMapper;
import api.demo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeServiceImpl implements EmployeeService{

    final EmployeeRepository repository;
    final EmployeeMapper employeeMapper;

    @Override
    public List<ShortEmployeeDto> getAllEmployees() {
        return repository.findAll().stream()
                .map(employeeMapper::toShortEmployeeDto)
                .toList();
    }

    @Override
    public ShortEmployeeDto addNewEmployee(FullEmployeeDto employeeDto) {
        return employeeMapper.toShortEmployeeDto(repository.save(employeeMapper.toEmployee(employeeDto)));
    }

    @Override
    public void deleteEmployee(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Запись Employee c id = " + id + " не существует");
        }
    }

}
