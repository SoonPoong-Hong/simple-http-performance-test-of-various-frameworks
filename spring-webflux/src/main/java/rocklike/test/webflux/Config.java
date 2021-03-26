package rocklike.test.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class Config {

    @Bean
    public AsyncConfigurerSupport async() {
        return new AsyncConfigurerSupport() {
            @Override
            public Executor getAsyncExecutor() {
                return Executors.newWorkStealingPool();
            }
        };
    }

    @Autowired
    private TestHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routes(){
        return
                RouterFunctions.route()
                        .GET("/skakdsafk-no-use", handler::handlePing_json)
                        .GET("/bkskfasdfas-no-use", handler::handlePing_json)
                        .GET("/rqekwkrqx-no-use", handler::handlePing_json)
                        .GET("/ping/{ping}", handler::handlePing)
                        .build()
                ;
    }
}
