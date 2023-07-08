package e41.ttn_1.controller;


import e41.ttn_1.dto.UserRequest;
import e41.ttn_1.dto.UserResponse;
import e41.ttn_1.entity.Users;
import e41.ttn_1.repository.UserRepository;
import e41.ttn_1.service.converter.UserConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @GetMapping
    public List<UserResponse> getAllUsers(){
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(userConverter::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        Users users = userConverter.toEntity(userRequest);
        Users saveUsers = userRepository.save(users);
        return userConverter.toResponseDTO(saveUsers);

    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Integer id){
        Users users = userRepository.findById(id).orElse(null);
        if (users != null){
            return userConverter.toResponseDTO(users);
        } else {
            return new UserResponse(-1,"User not found");
        }
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUserById(@PathVariable Integer id){
        Users searchResult = userRepository.findById(id).orElse(null);
        if (searchResult != null){
            userRepository.deleteById(id);
            return new UserResponse(id, "User delete successful");
        } else {
            return new UserResponse(-1,"User not found");
        }
    }

//    @GetMapping("/{nameandadress}")
//    public UserResponse getUserByNameAndAddress(@PathVariable String name, String address){
//
//        return new UserResponse();
//    }
}
