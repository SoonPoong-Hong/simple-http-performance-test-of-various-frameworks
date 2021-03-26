package rocklike.test.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    Router router = Router.router(vertx);

    router.get("/ping/:p").handler(ctx->{
      String p = ctx.request().getParam("p");
      String p3 = p + p + p;
      ctx.response().end(p3);
    })
    ;
    router.get("/kxkvasdf-no-use").handler(ctx->{
      ctx.json(new JsonObject().put("aa", ctx.getClass().getName()));
    });
    router.get("/bkxkfswkf-no-use").handler(ctx->{
      ctx.json(new JsonObject().put("aa", ctx.getClass().getName()));
    });
    router.get("/bkskfask-no-use").handler(ctx->{
      ctx.json(new JsonObject().put("aa", ctx.getClass().getName()));
    });

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080)
      .onSuccess(server ->
        System.out.println(
          "HTTP server started on port " + server.actualPort()
        )
      );
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }
}
