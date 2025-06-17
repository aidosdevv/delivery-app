package kz.deliver.deliver_mobile_app.services;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.models.User;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(Long id,UserDto userDto);
    boolean deleteUser(Long id);
    List<UserDto> getAllUsers();
    String changePassword(Long id,String oldPassword,String newPassword,String repeatNewPassword);
    UserDto becomeDriver(Long id);
    UserDto becomeCustomer(Long id);
}
