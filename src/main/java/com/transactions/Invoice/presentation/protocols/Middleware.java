package com.transactions.Invoice.presentation.protocols;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface Middleware {

    Mono<ServerResponse> handle(ServerRequest serverRequest);

}
