package e41.ttn_1.service.customers;

import e41.ttn_1.converter.CustomerConverter;
import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class FindCustomerByNameAndAddressAndRouteService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerResponse findAndCreateCustomerByNameAndAddressAndRoute(CustomerRequest request){
        Customers customer = customerRepository.findCustomerByNameAndAddressAndRoute(request.getName(),
                request.getAddress(), request.getRoute());
        if(customer == null){
            customer = customerRepository.save(customerConverter.toCustomer(request));
        }
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getAddress(), customer.getRoute(),
                customer.getAccessKey(), customer.getDateVisit());
    }
}
