package e41.ttn_1.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String name;
    private String address;
    private String route;
    private String accessKey;
    private LocalDate dateVisit;
}
