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
public class UserServceImpl implements UserService {

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
            updateUser.setOrders(user.getOrders());
            updateUser.setAge(user.getAge());
            updateUser.set_enabled(user.is_enabled());
            updateUser.setPassword(user.getPassword());
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
}
