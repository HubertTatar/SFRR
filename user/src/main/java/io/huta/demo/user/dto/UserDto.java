package io.huta.demo.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime registeredAt;
    private LocalDateTime disabledAt;
}
