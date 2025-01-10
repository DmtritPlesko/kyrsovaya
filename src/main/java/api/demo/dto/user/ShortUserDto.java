package api.demo.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortUserDto {
    Long userId;

    String name;

    public ShortUserDto (Long id,String name) {
        this.userId = id;
        this.name = name;
    }

}
