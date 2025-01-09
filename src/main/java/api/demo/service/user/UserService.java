package api.demo.service.user;
import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;

import java.util.List;

public interface UserService {

    List<ShortUserDto> getAllUsers();

    ShortUserDto addNewUser(FullUserDto userDto);

    void deleteUser(Long id);
}
