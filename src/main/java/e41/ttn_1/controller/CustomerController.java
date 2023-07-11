package e41.ttn_1.controller;

import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.service.customers.AddCustomerService;
import e41.ttn_1.service.customers.FindAllCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final AddCustomerService addCustomerService;
    private final FindAllCustomerService findAllCustomerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        List<CustomerResponse> responses = findAllCustomerService.findAllCustomer();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = addCustomerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
