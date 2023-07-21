package e41.ttn_1.DTO.ttns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TtnRequest {
    private String name;
    private String address;
    private String route;
    private String accessKey;
    private List<Integer> orders;
}
