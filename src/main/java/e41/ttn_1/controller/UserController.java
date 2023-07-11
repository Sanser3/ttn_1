package e41.ttn_1.controller;


import e41.ttn_1.dto.users.UserRequest;
import e41.ttn_1.dto.users.UserResponse;
import e41.ttn_1.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUser(){
        List<UserResponse> responses = userService.getAllUsers();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addNewUser(@RequestBody UserRequest request){
        UserResponse response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Integer id){
        UserResponse response = userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable Integer id){
        UserResponse response = userService.deleteUserById(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
