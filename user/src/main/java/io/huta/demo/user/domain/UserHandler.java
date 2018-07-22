package io.huta.demo.user.domain;

import io.huta.demo.user.command.CreateUser;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


public class UserHandler {

    private final UserRepository userRepository;
    private final UserCreator userCreator;

    public UserHandler(UserRepository userRepository, UserCreator userCreator) {
        this.userRepository = userRepository;
        this.userCreator = userCreator;
    }

    public Mono<ServerResponse> listUsers(ServerRequest request) {
        return ServerResponse
                .ok()
                .syncBody(userRepository.findAll());
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return request
                .bodyToMono(CreateUser.class)
                .map(userCreator::fromCmd)
                .flatMap(userRepository::insert)
                .flatMap(inserted -> ServerResponse.ok().syncBody(inserted));
    }

    public Mono<ServerResponse> getByUsername(ServerRequest request) {
        return ServerResponse
                .ok()
                .syncBody(userRepository
                        .findByUsername(request.pathVariable("username"))
                );
    }
}
