package e41.ttn_1.service.customers;

import e41.ttn_1.converter.CustomerConverter;
import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FindAllCustomerByRouteService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public List<CustomerResponse> findAllByRouteCustomer(String route){
        List<Customers> customers = customerRepository.findAllByRoute(route)
                .orElseThrow(() -> new IllegalAccessError("Customer not found"));
        return customers.stream()
                .map(customerConverter::toResponse)
                .collect(Collectors.toList());
    }
}
