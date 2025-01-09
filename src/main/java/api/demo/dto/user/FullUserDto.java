package api.demo.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullUserDto {

    Long userId;

    String name;

    String email;

    String phoneNumber;

    public FullUserDto (String name) {
        this.name = name;
    }
}
