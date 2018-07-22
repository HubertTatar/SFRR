package io.huta.demo.user.domain;

import io.huta.demo.user.command.CreateUser;

class UserCreator {

    User fromCmd(CreateUser createUser) {
        return User
                .builder()
                .firstName(createUser.getFirstName())
                .lastName(createUser.getLastName())
                .username(createUser.getUsername())
                .build();
    }

}
