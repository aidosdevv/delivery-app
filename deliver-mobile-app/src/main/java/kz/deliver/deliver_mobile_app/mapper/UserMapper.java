package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.UserDto;
import kz.deliver.deliver_mobile_app.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "madeOrders", target = "madeOrderIds", qualifiedByName = "mapOrderListToIdList")
    @Mapping(source = "takenOrders", target = "takenOrderIds", qualifiedByName = "mapOrderListToIdList")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    @Named("mapOrderListToIdList")
    static List<Long> mapOrderListToIdList(List<kz.deliver.deliver_mobile_app.models.Order> orders) {
        return orders == null ? null : orders.stream().map(kz.deliver.deliver_mobile_app.models.Order::getId).collect(Collectors.toList());
    }
}
