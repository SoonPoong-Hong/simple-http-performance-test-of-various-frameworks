package rocklike.test.akka

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

object ScalaHttpServer {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    implicit val executionContext = system.executionContext
    val route = {
      pathPrefix("ping") {
        path(Segment) { p:String =>
          concat(
            get {
              val s = p + p + p
              complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, s))
            }
          )
        }
      }
    }

    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bindFlow(route)
    println(s"Server online at http://localhost:8080/.")
  }
}