package paymentgateway

import paymentgateway.infrastructure.http.HttpServer
import zio._
import zio.http._
import paymentgateway.payment.repository.PaymentRepositoryLive

object Main extends ZIOAppDefault {

  override def run =
    Server
      .serve(HttpServer.app)
      .provide(
        Server.default,
        PaymentRepositoryLive.layer)
      .onInterrupt(
        Console.printLine("\nShutting down Payment Gateway...").orDie
      )
}
