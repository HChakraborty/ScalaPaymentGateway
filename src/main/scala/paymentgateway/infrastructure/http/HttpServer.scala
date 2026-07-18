package paymentgateway.infrastructure.http

import paymentgateway.health.api.HealthEndpoints
import paymentgateway.payment.api.PaymentRoutes

import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

import zio.*

import sttp.tapir.ztapir.*
import paymentgateway.payment.api.PaymentEndpoints

object HttpServer {

  private val endpoints =
    List(
      HealthEndpoints.routes.widen
    )
      ++ PaymentRoutes.routes

  private val openApi = SwaggerInterpreter()
    .fromServerEndpoints(endpoints, "Scala Payment Gateway", "0.1.0")

  val app =
    ZioHttpInterpreter().toHttp(
      endpoints
    ) ++
      ZioHttpInterpreter().toHttp(
        openApi
      )

}
