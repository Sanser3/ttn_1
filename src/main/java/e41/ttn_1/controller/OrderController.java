package e41.ttn_1.controller;

import e41.ttn_1.dto.orders.OrderRequest;
import e41.ttn_1.dto.orders.OrderResponse;
import e41.ttn_1.service.orders.AddOrderService;
import e41.ttn_1.service.orders.FindAllOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final AddOrderService addOrderService;
    private final FindAllOrderService findAllOrderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        List<OrderResponse> response = findAllOrderService.findAllOrderRequest();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> addNewOrder(@RequestBody OrderRequest request){
        OrderResponse response = addOrderService.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
