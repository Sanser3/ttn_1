package e41.ttn_1.converter;

import e41.ttn_1.dto.orders.OrderRequest;
import e41.ttn_1.dto.orders.OrderResponse;
import e41.ttn_1.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@AllArgsConstructor
public class OrderConverter {
    public Orders toOrder(OrderRequest orderRequest) {
        Orders newOrder = new Orders();
        newOrder.setOrders(orderRequest.getOrders());
        newOrder.setDateCreate(LocalDateTime.now());
        return newOrder;
    }

    public OrderResponse toResponse(Orders orders){
        return new OrderResponse(orders.getId(), orders.getOrders(), orders.getDateCreate());
    }

}
