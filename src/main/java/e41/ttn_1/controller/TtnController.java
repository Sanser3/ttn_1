package e41.ttn_1.controller;

import e41.ttn_1.DTO.ttns.TtnRequest;
import e41.ttn_1.DTO.ttns.TtnResponse;
import e41.ttn_1.service.TtnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ttns")
@AllArgsConstructor
public class TtnController {
    private final TtnService ttnService;

    @GetMapping
    public ResponseEntity<List<TtnResponse>> getAllTtn(){
        List<TtnResponse> responses = ttnService.findAllTtn();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TtnResponse> addNewTtn(@RequestBody TtnRequest request){
        TtnResponse response = ttnService.createTtn(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TtnResponse>> getAllTtnByDate(@PathVariable LocalDate date){
        List<TtnResponse> responses = ttnService.findAllByDateTtn(date);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/route/{route}")
    public ResponseEntity<List<TtnResponse>> getAllTtnByRoute(@PathVariable String route){
        List<TtnResponse> responses = ttnService.findAllByRoute(route);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
