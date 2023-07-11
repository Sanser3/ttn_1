package e41.ttn_1.service.orders;

import e41.ttn_1.dto.orders.OrderRequest;
import e41.ttn_1.dto.orders.OrderResponse;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.repository.OrderRepository;
import e41.ttn_1.converter.OrderConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AddOrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderResponse createOrder(OrderRequest orderRequest){
        Orders newOrder = orderConverter.toOrder(orderRequest);
        newOrder = orderRepository.save(newOrder);
        return new OrderResponse(newOrder.getId(), newOrder.getOrders(), newOrder.getDateCreate());
    }
}
