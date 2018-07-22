package io.huta.demo.infra.config;

import io.huta.demo.user.UserRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class Routes {

    private final UserRoute userRoute;

    public Routes(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    @Bean
    RouterFunction<ServerResponse> routing() {
        return nest(path("/user"), userRoute.routes());
    }

}
