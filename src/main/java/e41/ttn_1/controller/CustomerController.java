package e41.ttn_1.controller;

import e41.ttn_1.dto.customers.CustomerResponse;
import e41.ttn_1.dto.customers.CustomerRequest;
import e41.ttn_1.service.customers.*;
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
    private final UpdateCustomerService updateCustomerService;
    private final FindAllCustomerByRouteService findAllCustomerByRouteService;
    private final DeleteCustomerService deleteCustomerService;

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

    @GetMapping("/{route}")
    public ResponseEntity<List<CustomerResponse>> getAllCustomerByRoute(@PathVariable String route){
        List<CustomerResponse> responses = findAllCustomerByRouteService.findAllByRouteCustomer(route);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = updateCustomerService.updateCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<CustomerResponse> deleteCustomer(@RequestBody CustomerRequest request){
        CustomerResponse response = deleteCustomerService.deleteCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
