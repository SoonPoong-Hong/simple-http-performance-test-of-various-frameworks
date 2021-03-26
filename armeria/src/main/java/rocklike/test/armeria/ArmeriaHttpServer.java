package rocklike.test.armeria;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;

import java.util.concurrent.CompletableFuture;

public class ArmeriaHttpServer {
    public static void main(String[] args) {
        Server server = Server.builder().http(8080).annotatedService(new Service()).build();
        CompletableFuture<Void> future = server.start();
        future.join();
    }

    static class Service {
        @Get("/ping/:p")
        public HttpResponse ping(@Param("p") String p) {
            String p3 = p + p + p;
            return HttpResponse.of(
                    HttpStatus.OK,
                    MediaType.PLAIN_TEXT, p3);
        }

        @Get("/bkxkxkaf-no-use")
        public HttpResponse method2() {
            return HttpResponse.of(
                    HttpStatus.OK,
                    MediaType.HTML_UTF_8,
                    "<h1>Hello this is dummy method.</h1>");
        }

        @Get("/kxkwq-no-use")
        public HttpResponse method3() {
            return HttpResponse.of(
                    HttpStatus.OK,
                    MediaType.HTML_UTF_8,
                    "<h1>Hello this is dummy method.</h1>");
        }

        @Get("/vckzkxvc-no-use")
        public HttpResponse method4() {
            return HttpResponse.of(
                    HttpStatus.OK,
                    MediaType.HTML_UTF_8,
                    "<h1>Hello this is dummy method.</h1>");
        }

    }
}
