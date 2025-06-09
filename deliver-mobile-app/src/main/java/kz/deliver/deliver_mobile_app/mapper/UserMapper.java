package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "orderId", source = "order.id")
    UserDto toDto(User user);

    @Mapping(target = "order", ignore = true)
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> userList);
}
