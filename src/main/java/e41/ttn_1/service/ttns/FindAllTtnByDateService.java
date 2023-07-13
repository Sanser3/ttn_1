package e41.ttn_1.service.ttns;

import e41.ttn_1.converter.TtnConverter;
import e41.ttn_1.dto.ttns.TtnResponse;
import e41.ttn_1.entity.Ttns;
import e41.ttn_1.repository.TtnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class FindAllTtnByDateService {
    private final TtnRepository ttnRepository;
    private final TtnConverter ttnConverter;
    public List<TtnResponse> findAllByDateTtn(LocalDate date){
        List<Ttns> ttns = ttnRepository.findTtnsByCreateTtn(date);
        System.out.println("------------------> "+ttns);
        return ttns.stream().map(ttnConverter::toResponse).collect(Collectors.toList());

    }
}
