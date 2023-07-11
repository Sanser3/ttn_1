package e41.ttn_1.service.customers;

import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.converter.CustomerConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Data
@AllArgsConstructor
public class AddCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        Customers newCustomer = customerConverter.toCustomer(customerRequest);
        if (checkNewCustomer(newCustomer)){
            newCustomer = customerRepository.save(newCustomer);
            return new CustomerResponse(newCustomer.getId(), newCustomer.getName(), newCustomer.getAddress(),
                    newCustomer.getRoute(), newCustomer.getAccessKey(), LocalDate.now());
        }
            return new CustomerResponse(0, newCustomer.getName(), newCustomer.getAddress(),newCustomer.getRoute(),
                    "Customer already exist", LocalDate.now());
    }

    public boolean checkNewCustomer(Customers customer){
        return customerRepository.findByNameAndAddressAndRoute(customer.getName(), customer.getAddress(),
                customer.getRoute()).isEmpty();
    }

}
