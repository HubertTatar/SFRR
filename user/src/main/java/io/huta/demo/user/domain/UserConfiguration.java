package io.huta.demo.user.domain;

import io.huta.demo.user.UserRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserHandler userHandler(UserRepository userRepository) {
        return new UserHandler(userRepository, new UserCreator());
    }

    @Bean
    UserRoute userRoute(UserHandler userHandler) {
        return new UserRoute(userHandler);
    }

}
