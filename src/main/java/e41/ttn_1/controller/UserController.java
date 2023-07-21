//package e41.ttn_1.controller;
//
//import e41.ttn_1.DTO.users.UserRequest;
//import e41.ttn_1.DTO.users.UserResponse;
//import e41.ttn_1.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    @GetMapping
//    public @ResponseBody ResponseEntity<List<UserResponse>> getAll(){
//        List<UserResponse> responses = userService.getAll();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//    @PostMapping
//    public @ResponseBody ResponseEntity<UserResponse> addNewUser(@RequestBody UserRequest request){
//        UserResponse response = userService.createUser(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/login")
//    public @ResponseBody ResponseEntity<UserResponse> getAllByLogin(@RequestBody UserRequest request){
//        UserResponse response = userService.findByLogin(request.getLogin());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}
