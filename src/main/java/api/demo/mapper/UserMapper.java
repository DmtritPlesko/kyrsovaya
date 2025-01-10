package api.demo.mapper;

import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;
import api.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ShortUserDto toShortUserDto(User user) {

        ShortUserDto userDto = new ShortUserDto();

        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());

        return userDto;
    }

    public User toUser(FullUserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhoneNumber(user.getPhoneNumber());

        return user;
    }

    public FullUserDto toFullUserDto(User user) {
        FullUserDto fullUserDto = new FullUserDto();

        fullUserDto.setName(user.getName());
        fullUserDto.setEmail(user.getEmail());
        fullUserDto.setPhoneNumber(user.getPhoneNumber());

        return fullUserDto;
    }
}
