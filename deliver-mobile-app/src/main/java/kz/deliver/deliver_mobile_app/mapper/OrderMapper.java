package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "driver.id", target = "driverId")
    OrderDto toDto(Order order);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "driverId", target = "driver.id")
    Order toEntity(OrderDto dto);
}
