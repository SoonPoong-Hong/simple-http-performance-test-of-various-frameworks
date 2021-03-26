package hong

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._


class HongGatling_perf extends Simulation {

  val url = "http://localhost:8080"

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(url)
    .header("Cache-Control", "private, no-store, max-age=0")
    .shareConnections // => connection을 share 함.

  // https://gatling.io/docs/current/http/http_check/
  val scn: ScenarioBuilder = scenario("simple-test")

    .exec(http("ping").get(session => s"/ping/${System.currentTimeMillis()}")
      .disableFollowRedirect
      .check(status.in(200)))

  def millis: Long = System.currentTimeMillis();

  exeClosedModel()

  def exeClosedModel() = {
    setUp(
      scn.inject(
        rampConcurrentUsers(1) to (20) during (5 seconds),
        constantConcurrentUsers(10000) during (60 seconds),
      ).protocols(httpProtocol)
    )
  }

}
