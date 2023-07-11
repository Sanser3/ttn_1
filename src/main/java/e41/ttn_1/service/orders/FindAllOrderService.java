package e41.ttn_1.service.orders;

import e41.ttn_1.dto.orders.OrderResponse;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.repository.OrderRepository;
import e41.ttn_1.converter.OrderConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FindAllOrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public List<OrderResponse> findAllOrderRequest(){
        List<Orders> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderConverter::toResponse)
                .collect(Collectors.toList());
    }
}
