package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> userList);
}
