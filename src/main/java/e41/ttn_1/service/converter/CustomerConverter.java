package e41.ttn_1.service.converter;

import e41.ttn_1.dto.CustomerRequest;
import e41.ttn_1.entity.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@AllArgsConstructor
public class CustomerConverter {
    public Customers converterRequestToCustomer(CustomerRequest customerRequest){
        Customers newCustomer = new Customers();
        newCustomer.setName(customerRequest.getName());
        newCustomer.setAddress(customerRequest.getAddress());
        newCustomer.setAccessKey(String.valueOf((customerRequest.getName()+customerRequest.getAddress()).hashCode()));
        newCustomer.setDateVisit(LocalDateTime.now());
        return newCustomer;
    }
}
