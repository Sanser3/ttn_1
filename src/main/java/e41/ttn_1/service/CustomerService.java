package e41.ttn_1.service;

import e41.ttn_1.DTO.customers.CustomerRequest;
import e41.ttn_1.DTO.customers.CustomerResponse;
import e41.ttn_1.entity.Customers;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);

    boolean checkNewCustomer(Customers customer);

    List<CustomerResponse> findAllCustomer();

    List<CustomerResponse> findAllByRouteCustomer(String route);

    CustomerResponse findAndCreateCustomerByNameAndAddressAndRoute(CustomerRequest request);

    CustomerResponse updateCustomer(CustomerRequest request);

    CustomerResponse deleteCustomer(CustomerRequest request);

}
