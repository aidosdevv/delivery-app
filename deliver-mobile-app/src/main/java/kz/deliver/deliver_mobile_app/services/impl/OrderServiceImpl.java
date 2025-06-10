package kz.deliver.deliver_mobile_app.services.impl;

import kz.deliver.deliver_mobile_app.dto.OrderDto;
import kz.deliver.deliver_mobile_app.mapper.OrderMapper;
import kz.deliver.deliver_mobile_app.models.Order;
import kz.deliver.deliver_mobile_app.repository.OrderRepository;
import kz.deliver.deliver_mobile_app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        if(order != null){
            orderRepository.save(order);
        }
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElse(null);
        Order updateOrder = orderMapper.toEntity(orderDto);
        if(order != null){
            order.setName(updateOrder.getName());
            order.setPrice(updateOrder.getPrice());
            order.setDescription(updateOrder.getDescription());
            order.setFrom(updateOrder.getFrom());
            order.setTo(updateOrder.getTo());
            orderRepository.save(order);
        }
        return orderMapper.toDto(order);
    }

    @Override
    public boolean deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order!=null){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null){
            return orderMapper.toDto(order);
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
