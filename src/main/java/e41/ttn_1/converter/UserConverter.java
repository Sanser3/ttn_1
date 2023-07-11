package e41.ttn_1.converter;

import e41.ttn_1.dto.users.UserRequest;
import e41.ttn_1.dto.users.UserResponse;
import e41.ttn_1.entity.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserConverter {
    public Users toUser(UserRequest userRequest){
        Users newUsers = new Users();
        newUsers.setName(userRequest.getName());
        newUsers.setPassword(userRequest.getPassword());
        newUsers.setAccessKey(String.valueOf((userRequest.getName()+userRequest.getPassword()).hashCode()));
        newUsers.setDateVisit(LocalDateTime.now());
        return newUsers;
    }

    public UserResponse toResponse(Users users){
        return new UserResponse(users.getId(), users.getName(), users.getPassword(), users.getAccessKey());
    }
}
