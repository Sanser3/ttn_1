package e41.ttn_1.service.converter;

import e41.ttn_1.dto.CustomerRequest;
import e41.ttn_1.dto.CustomerResponse;
import e41.ttn_1.entity.Customers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerConverter {
    public CustomerResponse toResponseDTO(Customers customers){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customers.getId());
        customerResponse.setName(customers.getName());
        customerResponse.setAddress(customers.getAddress());
        return customerResponse;
    }

    public Customers toEntity(CustomerRequest dto){
        Customers customers = new Customers();
        customers.setName(dto.getName());
        customers.setAddress(dto.getAddress());
        customers.setDateVisit(LocalDateTime.now());
        return customers;
    }
}
