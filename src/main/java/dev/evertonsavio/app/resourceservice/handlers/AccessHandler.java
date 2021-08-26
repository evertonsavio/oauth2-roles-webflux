package dev.evertonsavio.app.resourceservice.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class AccessHandler {


    /*==================================================================================================================
    ==================================================================================================================*/
    public Mono<ServerResponse> microserviceHealth(ServerRequest request) {

        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(Flux.just("{healthy:true}"), String.class);
    }

}