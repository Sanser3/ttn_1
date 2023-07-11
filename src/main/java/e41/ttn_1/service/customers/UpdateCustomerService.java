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
public class UpdateCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerResponse updateCustomer(CustomerRequest request){
        Customers customerFourUpdate = customerRepository.findByAccessKey(request.getAccessKey())
                .orElseThrow(() -> new IllegalAccessError("User not found"));

        customerFourUpdate = customerConverter.updateCustomer(request, customerFourUpdate);
        customerRepository.save(customerFourUpdate);
        return new CustomerResponse(customerFourUpdate.getId(), customerFourUpdate.getName(),
                customerFourUpdate.getAddress(), customerFourUpdate.getRoute(),
                customerFourUpdate.getAccessKey(), LocalDate.now());
    }
}
