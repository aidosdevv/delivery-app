package kz.deliver.deliver_mobile_app.services;

import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.models.Order;

import java.util.List;

public interface OrderService {
    OrderDto addOrder(OrderDto orderDto);
    OrderDto updateOrder(Long id,OrderDto orderDto);
    boolean deleteOrder(Long id);
    OrderDto getOrderById(Long id);
    List<Order> getAllOrders();
    OrderDto setDriver(Long driverId,Long orderId);

}
