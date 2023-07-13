package e41.ttn_1.controller;

import e41.ttn_1.dto.ttns.TtnRequest;
import e41.ttn_1.dto.ttns.TtnResponse;
import e41.ttn_1.service.ttns.AddTtnService;
import e41.ttn_1.service.ttns.FindAllTtnByDateService;
import e41.ttn_1.service.ttns.FindAllTtnByRouteService;
import e41.ttn_1.service.ttns.FindAllTtnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ttns")
@AllArgsConstructor
public class TtnController {
    private final FindAllTtnService findAllTtnService;
    private final AddTtnService addTtnService;
    private final FindAllTtnByDateService findAllTtnByDateService;
    private final FindAllTtnByRouteService findAllTtnByRouteService;

    @GetMapping
    public ResponseEntity<List<TtnResponse>> getAllTtn(){
        List<TtnResponse> responses = findAllTtnService.findAllTtn();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TtnResponse> addNewTtn(@RequestBody TtnRequest request){
        TtnResponse response = addTtnService.createTtn(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TtnResponse>> getAllTtnByDate(@PathVariable LocalDate date){
        List<TtnResponse> responses = findAllTtnByDateService.findAllByDateTtn(date);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/route/{route}")
    public ResponseEntity<List<TtnResponse>> getAllTtnByRoute(@PathVariable String route){
        List<TtnResponse> responses = findAllTtnByRouteService.findAllByRoute(route);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
