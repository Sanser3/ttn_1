package e41.ttn_1.dto;

import e41.ttn_1.entity.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAllCustomerResponse {
    private List<Customers> allCustomer;
    private String responseMessage;
}
