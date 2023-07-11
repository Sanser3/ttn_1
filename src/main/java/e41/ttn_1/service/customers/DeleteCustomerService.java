package e41.ttn_1.service.customers;

import e41.ttn_1.converter.CustomerConverter;
import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Data
@AllArgsConstructor
public class DeleteCustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponse deleteCustomer(CustomerRequest request){
        Customers customer = customerRepository.findByAccessKey(request.getAccessKey())
                .orElseThrow(() -> new IllegalAccessError("User not found"));
        customerRepository.delete(customer);
        return new CustomerResponse(customer.getId(), customer.getName(),
                customer.getAddress(), customer.getRoute(),
                customer.getAccessKey(), LocalDate.now());
    }
}
