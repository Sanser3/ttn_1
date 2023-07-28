package e41.ttn_1.service;

import e41.ttn_1.DTO.orders.OrderRequest;
import e41.ttn_1.DTO.orders.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);

    List<OrderResponse> findAllOrderRequest();

}
