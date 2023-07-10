package e41.ttn_1.service.customers;

import e41.ttn_1.dto.CustomerRequest;
import e41.ttn_1.dto.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.service.converter.CustomerConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AddNewCustomerService {

    private final CustomerConverter customerConverter;
    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        Customers newCustomer = customerConverter.converterRequestToCustomer(customerRequest);
        if (checkNewCustomer(newCustomer)){
            newCustomer = customerRepository.save(newCustomer);
            return new CustomerResponse(newCustomer.getId(), newCustomer.getName(), newCustomer.getAddress(),
                    newCustomer.getAccessKey(), "OK");
        }
            return new CustomerResponse(0, newCustomer.getName(), newCustomer.getAddress(),
                    "0", "Customer already exist");
    }

    public boolean checkNewCustomer(Customers customer){
        return customerRepository.findByNameAndAddress(customer.getName(), customer.getAddress()).isEmpty();
    }

}
