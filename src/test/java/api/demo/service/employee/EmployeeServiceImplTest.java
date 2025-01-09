package api.demo.service.employee;

import api.demo.dto.employee.FullEmployeeDto;
import api.demo.dto.employee.ShortEmployeeDto;
import api.demo.mapper.EmployeeMapper;
import api.demo.model.Employee;
import api.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "John"),
                new Employee(2L, "Jane")
        );

        when(repository.findAll()).thenReturn(employees);

        List<ShortEmployeeDto> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    void testAddNewEmployee() {
        FullEmployeeDto employeeDto = new FullEmployeeDto("John");

        Employee expectedEmployee = new Employee(1L, "John");
        when(repository.save(any())).thenReturn(expectedEmployee);

        when(employeeMapper.toEmployee(any(FullEmployeeDto.class))).thenReturn(expectedEmployee);
        when(employeeMapper.toShortEmployeeDto(expectedEmployee)).thenReturn(new ShortEmployeeDto(1L, "John Doe"));

        ShortEmployeeDto result = employeeService.addNewEmployee(employeeDto);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(repository).save(any());
    }

    @Test
    void testDeleteNonExistentEmployee() {
        Long nonExistentId = 999L;

        assertThrows(IllegalArgumentException.class, () ->
                employeeService.deleteEmployee(nonExistentId)
        );
    }
}
