package e41.ttn_1.controller;

import e41.ttn_1.dto.CustomerRequest;
import e41.ttn_1.dto.CustomerResponse;
import e41.ttn_1.entity.Customers;
import e41.ttn_1.repository.CustomerRepository;
import e41.ttn_1.service.converter.CustomerConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @GetMapping
    public List<CustomerResponse> getAllCustomers(){
        List<Customers> customersList = customerRepository.findAll();
        return customersList.stream()
                .map(customerConverter::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest){
        Customers customers = customerConverter.toEntity(customerRequest);
        Customers saveCustomers = customerRepository.save(customers);
        return customerConverter.toResponseDTO(saveCustomers);
    }

    public List<CustomerResponse> findByNameAndAddress()
}
