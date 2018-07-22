package io.huta.demo.user.command;

import lombok.Data;

@Data
public class UpdateUser {
    private String username;
    private String firstName;
    private String lastName;
}
