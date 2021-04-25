package com.vishnu.learning.handler;

import com.vishnu.learning.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    @Autowired
    private IGreetingService greetingService;

    public Mono<ServerResponse> hello(ServerRequest request) {
        String mon = greetingService.sayHello();
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(mon));
    }
}