package dev.evertonsavio.app.resourceservice.routers;

import dev.evertonsavio.app.resourceservice.handlers.AccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class AccessRouter {

    /*==================================================================================================================
    ROUTES:
    ==================================================================================================================*/
    @Bean
    public RouterFunction<ServerResponse> healthRouters(AccessHandler accessHandler) {
       return RouterFunctions.route(RequestPredicates.
               GET("/")
               .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), accessHandler::microserviceHealth)
               .andRoute(
               GET("/resource-service/")
               .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), accessHandler::microserviceHealth)
               .andRoute(
               POST("/resource-service/v1/log/{mac}")
               .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), accessHandler::microserviceHealth)
               .andRoute(
               GET("/resource-service/v1/file/{mac}")
               .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), accessHandler::microserviceHealth);
   }

}/*===================================================================================================================*/