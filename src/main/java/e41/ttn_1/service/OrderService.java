package e41.ttn_1.service;

import e41.ttn_1.DTO.orders.OrderRequest;
import e41.ttn_1.DTO.orders.OrderResponse;
import e41.ttn_1.converter.OrderConverter;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderResponse createOrder(OrderRequest orderRequest){
        Orders newOrder = orderConverter.toOrder(orderRequest);
        newOrder = orderRepository.save(newOrder);
        return new OrderResponse(newOrder.getId(), newOrder.getOrders(), newOrder.getDateCreate());
    }

    public List<OrderResponse> findAllOrderRequest(){
        List<Orders> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderConverter::toResponse)
                .collect(Collectors.toList());
    }
}
