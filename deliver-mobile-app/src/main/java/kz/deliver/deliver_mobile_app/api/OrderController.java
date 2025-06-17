package kz.deliver.deliver_mobile_app.api;


import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.models.Order;
import kz.deliver.deliver_mobile_app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderDto addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto,@PathVariable Long id){
        return orderService.updateOrder(id,orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrderById(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

    @PutMapping("/{driverId}/{orderId}")
    public OrderDto setDriverById(@PathVariable Long driverId,@PathVariable Long orderId){
        return orderService.setDriver(driverId,orderId);
    }

}
