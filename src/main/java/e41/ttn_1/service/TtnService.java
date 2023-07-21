package e41.ttn_1.service;

import e41.ttn_1.DTO.ttns.TtnRequest;
import e41.ttn_1.DTO.ttns.TtnResponse;
import e41.ttn_1.converter.TtnConverter;
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
public class TtnService {
    private final TtnRepository ttnRepository;
    private final TtnConverter ttnConverter;

    public TtnResponse createTtn(TtnRequest ttnRequest) {
        Ttns newTtn = ttnConverter.toTtn(ttnRequest);
        newTtn = ttnRepository.save(newTtn);
        return new TtnResponse(newTtn.getId(), newTtn.getCustomers(), newTtn.getOrders(),
                String.valueOf((ttnRequest.getName()+ttnRequest.getAddress()+ttnRequest.getRoute()).hashCode()),
                LocalDate.now());
    }

    public List<TtnResponse> findAllByDateTtn(LocalDate date){
        List<Ttns> ttns = ttnRepository.findTtnsByCreateTtn(date);
//        List<Ttns> ttns = ttnRepository.findAll();
        return ttns.stream().map(ttnConverter::toResponse).collect(Collectors.toList());

    }

    public List<TtnResponse> findAllByRoute(String route){
        List<Ttns> ttns = ttnRepository.findAll().stream()
                .filter(ttns1 -> ttns1.getCustomers().getRoute().equals(route))
                .toList();
        return ttns.stream().map(ttnConverter::toResponse).collect(Collectors.toList());
    }

    public List<TtnResponse> findAllTtn(){
        List<Ttns> ttns = ttnRepository.findAll();
        return ttns.stream().map(ttnConverter::toResponse).collect(Collectors.toList());
    }

}
