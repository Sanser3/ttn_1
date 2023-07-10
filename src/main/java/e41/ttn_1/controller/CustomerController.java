package e41.ttn_1.controller;

import e41.ttn_1.dto.CustomerResponse;
import e41.ttn_1.dto.CustomerRequest;
import e41.ttn_1.dto.FindAllCustomerResponse;
import e41.ttn_1.service.customers.AddNewCustomerService;
import e41.ttn_1.service.customers.FindAllCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final AddNewCustomerService addNewCustomerService;
    private final FindAllCustomerService findAllCustomerService;

    @GetMapping
    public ResponseEntity<FindAllCustomerResponse> getAllCustomer(){
        FindAllCustomerResponse response = findAllCustomerService.findAllCustomerRequest();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = addNewCustomerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
