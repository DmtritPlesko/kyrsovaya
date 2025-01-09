package api.demo.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FullRequestDto {

    Long ticketId;

    Long employeeId;

    Long userId;

    String status;

    String description;

    LocalDateTime dateCreated;

    LocalDateTime closeDate;
}
