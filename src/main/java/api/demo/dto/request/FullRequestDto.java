package api.demo.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullRequestDto {

    Long employeeId;

    Long userId;

    String status;

    String description;

    LocalDateTime dateCreated;

    LocalDateTime closeDate;
}
