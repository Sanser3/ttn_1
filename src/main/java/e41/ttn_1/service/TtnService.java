package e41.ttn_1.service;

import e41.ttn_1.DTO.ttns.TtnRequest;
import e41.ttn_1.DTO.ttns.TtnResponse;

import java.time.LocalDate;
import java.util.List;


public interface TtnService {

    TtnResponse createTtn(TtnRequest ttnRequest);

    List<TtnResponse> findAllByDateTtn(LocalDate date);

    List<TtnResponse> findAllByRoute(String route);

    List<TtnResponse> findAllTtn();

}
