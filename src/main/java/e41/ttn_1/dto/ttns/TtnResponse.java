package e41.ttn_1.dto.ttns;

import e41.ttn_1.entity.Customers;
import e41.ttn_1.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TtnResponse {
    private Integer id;
    private Customers customer;
    private Orders order;
    private String accessKey;
    private LocalDate dateCreate;
}
