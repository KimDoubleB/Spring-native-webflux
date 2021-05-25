package bb.aws.lambda.webfluxnativedemo.handler;

import bb.aws.lambda.webfluxnativedemo.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PingHandler {

    private final PrintService printService;

    public PingHandler(PrintService printService) {
        this.printService = printService;
    }

    public Mono<ServerResponse> ping(ServerRequest request) {
        printService.print();

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("pong"), String.class);
    }

    public Mono<ServerResponse> pingRawData(ServerRequest request) {
        var stringMono = request.bodyToMono(String.class);
        return stringMono
                .flatMap(s -> ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(s), String.class));
    }
}
