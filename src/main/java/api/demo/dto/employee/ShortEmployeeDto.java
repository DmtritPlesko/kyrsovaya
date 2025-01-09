package api.demo.dto.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortEmployeeDto {

    Long employeeId;

    String name;

    String title;

    public ShortEmployeeDto(Long id, String name) {
        this.employeeId = id;
        this.name = name;
    }
}
