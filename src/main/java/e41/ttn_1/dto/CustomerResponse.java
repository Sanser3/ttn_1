package e41.ttn_1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String name;
    private String address;
    private String accessKey;
    private String responseMessage;
}
