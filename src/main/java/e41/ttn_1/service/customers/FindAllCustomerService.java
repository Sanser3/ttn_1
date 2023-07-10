package e41.ttn_1.service.customers;

import e41.ttn_1.dto.FindAllCustomerResponse;
import e41.ttn_1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class FindAllCustomerService {
    private final CustomerRepository customerRepository;

    public FindAllCustomerResponse findAllCustomerRequest(){
        return new FindAllCustomerResponse(customerRepository.findAll(), "OK");
    }
}
