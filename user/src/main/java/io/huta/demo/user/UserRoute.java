package io.huta.demo.user;

import io.huta.demo.user.domain.UserHandler;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class UserRoute {

    private final UserHandler userHandler;

    public UserRoute(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    public RouterFunction<ServerResponse> routes() {
        return route(POST("/"), userHandler::createUser)
                .andRoute(GET("/"), userHandler::listUsers);
    }
}
