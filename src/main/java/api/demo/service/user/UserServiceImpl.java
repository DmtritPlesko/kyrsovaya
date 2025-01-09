package api.demo.service.user;

import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;
import api.demo.mapper.UserMapper;
import api.demo.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{

    final UserRepository repository;
    final UserMapper userMapper;

    @Override
    public List<ShortUserDto> getAllUsers() {
        return repository.findAll().stream()
                .map(userMapper::toShortUserDto)
                .toList();

    }

    @Override
    public ShortUserDto addNewUser(FullUserDto userDto) {
        return userMapper.toShortUserDto(repository.save(userMapper.toUser(userDto)));
    }

    @Override
    public void deleteUser(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Запись User c id = " + id + " не существует");
        }
    }

}
