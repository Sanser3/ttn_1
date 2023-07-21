//package e41.ttn_1.converter;
//
//import e41.ttn_1.DTO.users.UserRequest;
//import e41.ttn_1.DTO.users.UserResponse;
//import e41.ttn_1.entity.Users;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.stereotype.Service;
//
//@Service
//@Data
//@AllArgsConstructor
//public class UserConverter {
//    public Users toUser(UserRequest request) {
//        return new Users(0, request.getLogin(), request.getPassword(), request.getUsername());
//    }
//
//    public UserResponse toResponse(Users users){
//        return new UserResponse(users.getId(), users.getLogin(), users.getPassword(), users.getUsername());
//    }
//
//}
