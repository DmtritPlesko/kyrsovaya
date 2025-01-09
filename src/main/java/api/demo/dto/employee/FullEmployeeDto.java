package api.demo.dto.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullEmployeeDto {

    Long employeeId;

    String name;

    String phoneNumber;

    String title;

    Boolean availability;

    public FullEmployeeDto (String name) {
        this.name = name;
    }
}
