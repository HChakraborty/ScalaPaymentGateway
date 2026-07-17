package paymentgateway.infrastructure.http

import paymentgateway.health.api.HealthEndpoints

import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.ztapir.RichZEndpoint

import zio.*

object HttpServer {

    val healthRoute: ServerEndpoint[Any, Task] =
        HealthEndpoints.healthEndpoint
        .zServerLogic {
            _ => ZIO.succeed("Scala Payment Gateway is running!")
        }

    val app =
        ZioHttpInterpreter().toHttp(
            List(healthRoute)
        )

}