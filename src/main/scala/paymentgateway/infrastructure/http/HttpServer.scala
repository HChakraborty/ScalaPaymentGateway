package paymentgateway.infrastructure.http

import paymentgateway.health.api.HealthEndpoints
import paymentgateway.payment.api.PaymentEndpoints

import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

import zio.*

import sttp.tapir.ztapir.*
import paymentgateway.payment.api.PaymentEndpoints

object HttpServer {

  private val endpoints = List(
    HealthEndpoints.routes.widen,
    PaymentEndpoints.routes.widen
  )

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
