package rocklike.test.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Mono<ServerResponse> handlePing(final ServerRequest req){
        String ping = req.pathVariable("ping");
        String p3 = ping+ping+ping;
        Mono<String> one = Mono.just(p3);
        Mono<ServerResponse> response = ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(one, String.class);
        return response;
    }

    public Mono<ServerResponse> handlePing2(final ServerRequest req){
        String ping = req.pathVariable("ping");
        String p3 = ping+ping+ping;
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue(p3));
    }

    public Mono<ServerResponse> handlePing_json(final ServerRequest req){
        String ping = req.pathVariable("ping");
        Map<String,String> m = new HashMap<>();
        m.put("ping", ping+ping+ping);
        Mono<Map<String, String>> one = Mono.just(m);
        Mono<ServerResponse> response = ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(one, Map.class);
        return response;
    }




}
