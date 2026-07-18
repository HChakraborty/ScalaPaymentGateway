package paymentgateway.health.api

import sttp.tapir.ztapir.*

import zio.*

object HealthEndpoints {

  private val healthEndpoint =
    endpoint.get
      .in("health")
      .out(stringBody)

  val routes: ZServerEndpoint[Any, Any] = HealthEndpoints.healthEndpoint
      .zServerLogic { _ =>
        ZIO.succeed("Scala Payment Gateway is running!")
      }
    

}
