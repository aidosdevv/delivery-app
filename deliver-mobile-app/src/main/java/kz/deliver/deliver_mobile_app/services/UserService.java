package kz.deliver.deliver_mobile_app.services;

import kz.deliver.deliver_mobile_app.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(Long id,UserDto userDto);
    boolean deleteUser(Long id);
    List<UserDto> getAllUsers();
}
