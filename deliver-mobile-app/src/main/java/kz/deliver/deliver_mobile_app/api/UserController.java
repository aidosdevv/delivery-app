package kz.deliver.deliver_mobile_app.api;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

}
