package e41.ttn_1.service.ttns;

import e41.ttn_1.converter.TtnConverter;
import e41.ttn_1.dto.ttns.TtnRequest;
import e41.ttn_1.dto.ttns.TtnResponse;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.repository.TtnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
@AllArgsConstructor
public class AddTtnService {
    private final TtnRepository ttnRepository;
    private final TtnConverter ttnConverter;

    public TtnResponse createTtn(TtnRequest ttnRequest) {
        Ttns newTtn = ttnConverter.toTtn(ttnRequest);
        newTtn = ttnRepository.save(newTtn);
        return new TtnResponse(newTtn.getId(), newTtn.getCustomers(), newTtn.getOrders(),
                String.valueOf((ttnRequest.getName()+ttnRequest.getAddress()+ttnRequest.getRoute()).hashCode()),
                LocalDate.now());
    }

}
