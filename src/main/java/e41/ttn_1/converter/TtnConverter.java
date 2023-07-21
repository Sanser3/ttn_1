package e41.ttn_1.converter;

import e41.ttn_1.DTO.customers.CustomerRequest;
import e41.ttn_1.DTO.customers.CustomerResponse;
import e41.ttn_1.DTO.orders.OrderRequest;
import e41.ttn_1.DTO.orders.OrderResponse;
import e41.ttn_1.DTO.ttns.TtnRequest;
import e41.ttn_1.DTO.ttns.TtnResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.service.CustomerService;
import e41.ttn_1.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
@AllArgsConstructor
public class TtnConverter {
    private final CustomerService customerService;
    private final OrderService orderService;

    private final CustomerConverter customerConverter;
    private final OrderConverter orderConverter;
    
    public TtnResponse toResponse(Ttns ttns){
        return new TtnResponse(ttns.getId(), ttns.getCustomers(), ttns.getOrders(), ttns.getAccessKey(), LocalDate.now());
    }

    public Ttns toTtn(TtnRequest ttnRequest) {
        CustomerRequest customerRequest = new CustomerRequest(ttnRequest.getName(), ttnRequest.getAddress(),
                ttnRequest.getRoute(),
                String.valueOf((ttnRequest.getName()+ttnRequest.getAddress()+ttnRequest.getRoute()).hashCode()));
        OrderRequest orderRequest = new OrderRequest(ttnRequest.getOrders());

        CustomerResponse customerResponse = customerService
                .findAndCreateCustomerByNameAndAddressAndRoute(customerRequest);

        OrderResponse orderResponse = orderService.createOrder(orderRequest);

        return new Ttns(0, customerResponseToCustomer(customerResponse),
                orderResponseToOrder(orderResponse),
                String.valueOf((ttnRequest.getName()+ttnRequest.getAddress()+ttnRequest.getRoute()).hashCode()),
                LocalDate.now());
    }

    public Customers customerResponseToCustomer(CustomerResponse response){
        return new Customers(response.getId(), response.getName(), response.getAddress(), response.getRoute(),
                response.getAccessKey(), response.getDateVisit());
    }

    public Orders orderResponseToOrder(OrderResponse response){
        return new Orders(response.getId(), response.getOrders(), response.getDateCreate());
    }
    
    public Ttns updateOrderByCustomer(Ttns ttn, TtnRequest request){
        ttn.setOrders((Orders) request.getOrders());
        return ttn;
    }
}
