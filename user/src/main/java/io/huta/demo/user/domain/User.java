package io.huta.demo.user.domain;

import io.huta.demo.user.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@Data
class User {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime registeredAt;
    private LocalDateTime disabledAt;


    public UserDto toDto() {
        return UserDto
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .disabledAt(disabledAt)
                .registeredAt(registeredAt)
                .build();
    }

}
