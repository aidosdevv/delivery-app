package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.models.Order;
import kz.deliver.deliver_mobile_app.models.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "driver.id", target = "driverId")
    OrderDto toDto(Order order);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "driver", ignore = true)
    Order toEntity(OrderDto dto);

    @AfterMapping
    default void setCustomerAndDriver(OrderDto dto, @MappingTarget Order order) {
        if (dto.getCustomerId() != null) {
            User customer = new User();
            customer.setId(dto.getCustomerId());
            order.setCustomer(customer);
        }

        if (dto.getDriverId() != null) {
            User driver = new User();
            driver.setId(dto.getDriverId());
            order.setDriver(driver);
        }
    }
}
