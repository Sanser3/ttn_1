package e41.ttn_1.service.ttns;

import e41.ttn_1.converter.TtnConverter;
import e41.ttn_1.dto.ttns.TtnResponse;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.repository.TtnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FindAllTtnService {
    private final TtnRepository ttnRepository;
    private final TtnConverter ttnConverter;
    public List<TtnResponse> findAllTtn(){
        List<Ttns> ttns = ttnRepository.findAll();
        return ttns.stream().map(ttnConverter::toResponse).collect(Collectors.toList());
    }
}
