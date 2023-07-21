package e41.ttn_1.controller;

import e41.ttn_1.DTO.customers.CustomerResponse;
import e41.ttn_1.DTO.customers.CustomerRequest;
import e41.ttn_1.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        List<CustomerResponse> responses = customerService.findAllCustomer();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = customerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{route}")
    public ResponseEntity<List<CustomerResponse>> getAllCustomerByRoute(@PathVariable String route){
        List<CustomerResponse> responses = customerService.findAllByRouteCustomer(route);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<CustomerResponse> getCustomerAndCreateCustomerByNameAndAddressAndRoute(
            @RequestBody CustomerRequest request){
        CustomerResponse response = customerService.findAndCreateCustomerByNameAndAddressAndRoute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = customerService.updateCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<CustomerResponse> deleteCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = customerService.deleteCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
