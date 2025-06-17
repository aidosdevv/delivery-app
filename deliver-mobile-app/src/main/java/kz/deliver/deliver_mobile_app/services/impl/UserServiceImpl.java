package kz.deliver.deliver_mobile_app.services.impl;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.mapper.UserMapper;
import kz.deliver.deliver_mobile_app.models.User;
import kz.deliver.deliver_mobile_app.repository.UserRepository;
import kz.deliver.deliver_mobile_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            return userMapper.toDto(user);
        }
        return null;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if(user != null){
            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updateUser = userRepository.findById(id).orElse(null);
        if(updateUser != null){
            updateUser.setUsername(user.getUsername());
            updateUser.setEmail(user.getEmail());
            updateUser.setAge(user.getAge());
            updateUser.setEnabled(false);
            updateUser.setPassword(user.getPassword());
            updateUser.setRole(user.getRole());
            userRepository.save(updateUser);
            return userMapper.toDto(userRepository.save(updateUser));
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public String changePassword(Long id, String oldPassword, String newPassword, String repeatNewPassword) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "User not found";
        }

        //if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
        //    return "Old password is incorrect";
        //}

        if (!newPassword.equals(repeatNewPassword)) {
            return "New password is not equal to repeat new password";
        }

        //user.setPassword(passwordEncoder.encode(newPassword));
        user.setPassword(newPassword);
        userRepository.save(user);

        return "Password successfully changed";
    }

    @Override
    public UserDto becomeDriver(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            return null;
        }
        user.setEnabled(true);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto becomeCustomer(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            return null;
        }
        user.setEnabled(false);
        userRepository.save(user);
        return userMapper.toDto(user);
    }


}
