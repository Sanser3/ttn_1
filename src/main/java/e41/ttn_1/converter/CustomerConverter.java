package e41.ttn_1.converter;

import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@AllArgsConstructor
public class CustomerConverter {
    public Customers toCustomer(CustomerRequest customerRequest){
        return new Customers(0,customerRequest.getName(), customerRequest.getAddress(), customerRequest.getRoute(),
                String.valueOf((customerRequest.getName()+customerRequest.getAddress()).hashCode()),
                LocalDateTime.now());
    }

    public CustomerResponse toResponse(Customers customers){
        return new CustomerResponse(customers.getId(), customers.getName(),
                customers.getAddress(), customers.getRoute(), customers.getAccessKey());
    }
}
