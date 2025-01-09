package api.demo.service.user;

import api.demo.dto.user.FullUserDto;
import api.demo.dto.user.ShortUserDto;
import api.demo.mapper.UserMapper;
import api.demo.model.User;
import api.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "John"),
                new User(2L, "Jane")
        );

        when(repository.findAll()).thenReturn(users);

        List<ShortUserDto> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    void testAddNewUser() {
        FullUserDto userDto = new FullUserDto("John");

        User expectedUser = new User(1L, "John");
        when(repository.save(any())).thenReturn(expectedUser);

        when(userMapper.toUser(any(FullUserDto.class))).thenReturn(expectedUser);
        when(userMapper.toShortUserDto(expectedUser)).thenReturn(new ShortUserDto(1L, "John Doe"));

        ShortUserDto result = userService.addNewUser(userDto);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(repository).save(any());
    }

    @Test
    void testDeleteNonExistentUser() {
        Long nonExistentId = 999L;

        assertThrows(IllegalArgumentException.class, () ->
                userService.deleteUser(nonExistentId)
        );
    }
}
