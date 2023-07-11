package e41.ttn_1.service.customers;

import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.converter.CustomerConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AddCustomerService {

    private final CustomerConverter customerConverter;
    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        Customers newCustomer = customerConverter.toCustomer(customerRequest);
        if (checkNewCustomer(newCustomer)){
            newCustomer = customerRepository.save(newCustomer);
            return new CustomerResponse(newCustomer.getId(), newCustomer.getName(), newCustomer.getAddress(),
                    newCustomer.getRoute(), newCustomer.getAccessKey());
        }
            return new CustomerResponse(0, newCustomer.getName(), newCustomer.getAddress(),newCustomer.getRoute(),
                    "Customer already exist");
    }

    public boolean checkNewCustomer(Customers customer){
        return customerRepository.findByNameAndAddressAndRoute(customer.getName(), customer.getAddress(),
                customer.getRoute()).isEmpty();
    }

}
