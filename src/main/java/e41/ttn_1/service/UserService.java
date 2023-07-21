//package e41.ttn_1.service;
//
//import e41.ttn_1.DTO.users.UserRequest;
//import e41.ttn_1.DTO.users.UserResponse;
//import e41.ttn_1.converter.UserConverter;
//import e41.ttn_1.entity.Users;
//import e41.ttn_1.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Data
//@AllArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final UserConverter userConverter;
//    public UserResponse createUser(UserRequest request) {
//        Users newUsers = userConverter.toUser(request);
//        newUsers = userRepository.save(newUsers);
//        return userConverter.toResponse(newUsers);
//    }
//
//    public List<UserResponse> getAll(){
//        List<Users> users = userRepository.findAll();
//        return users.stream()
//                .map(userConverter::toResponse)
//                .collect(Collectors.toList());
//    }
//
//    public UserResponse findByLogin(String login){
//        Users users = userRepository.findByLogin(login);
//        return userConverter.toResponse(users);
//
//    }
////        return userRepository.findAll().stream()
////                .filter(user -> login.equals(user.getLogin()))
////                .findFirst()
////                .orElse(null);
//}
