package e41.ttn_1.service.converter;

import e41.ttn_1.dto.UserRequest;
import e41.ttn_1.dto.UserResponse;
import e41.ttn_1.entity.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserConverter {
    public UserResponse toResponseDTO(Users users){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(users.getId());
        userResponse.setUsername(users.getUsername());
        return userResponse;
    }

    public Users toEntity(UserRequest dto){
        Users users = new Users();
        users.setUsername(dto.getUsername());
        users.setPassword(dto.getPassword());
        users.setAccessKey(String.valueOf((dto.getUsername()+dto.getPassword()).hashCode()));
        users.setDateVisit(LocalDateTime.now());
        return users;

    }
}
