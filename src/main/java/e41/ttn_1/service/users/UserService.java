package e41.ttn_1.service.users;

import e41.ttn_1.dto.users.UserRequest;
import e41.ttn_1.dto.users.UserResponse;
import e41.ttn_1.entity.Users;
import e41.ttn_1.repository.UserRepository;
import e41.ttn_1.converter.UserConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserResponse createUser(@RequestBody UserRequest userRequest){
        Users users = userConverter.toUser(userRequest);
        Users saveUsers = userRepository.save(users);
        return userConverter.toResponse(saveUsers);
    }

    public List<UserResponse> getAllUsers(){
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(userConverter::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(@PathVariable Integer id){
        Users users = userRepository.findById(id).orElse(null);
        if (users != null){
            return userConverter.toResponse(users);
        } else {
            return new UserResponse(-1,"User not found", "0","0");
        }
    }

    public UserResponse deleteUserById(@PathVariable Integer id){
        Users searchResult = userRepository.findById(id).orElse(null);
        if (searchResult != null){
            userRepository.deleteById(id);
            return new UserResponse(id, "User delete successful",
                    searchResult.getPassword(), searchResult.getAccessKey());
        } else {
            return new UserResponse(-1,"User not found","0","0");
        }
    }
}
