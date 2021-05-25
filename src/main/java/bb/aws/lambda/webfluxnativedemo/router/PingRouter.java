package bb.aws.lambda.webfluxnativedemo.router;

import bb.aws.lambda.webfluxnativedemo.handler.PingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PingRouter {

    @Bean
    RouterFunction<ServerResponse> pingRoutes(final PingHandler handler) {
        return route().path("/ping", builder -> {
            builder.add(route(GET(""), handler::ping));
            builder.add(route(POST("/raw"), handler::pingRawData));
        }).build();
    }
}
