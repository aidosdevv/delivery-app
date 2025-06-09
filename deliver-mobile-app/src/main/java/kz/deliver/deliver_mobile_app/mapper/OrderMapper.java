package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Order> orders);
}
