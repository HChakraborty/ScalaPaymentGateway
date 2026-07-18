package paymentgateway.payment.api

import paymentgateway.payment.model.*

import sttp.tapir.ztapir.*
import sttp.tapir.json.zio.*
import sttp.tapir.generic.auto.*

import zio.*

import java.util.UUID

object PaymentEndpoints {

  private val createPaymentRequest =
    endpoint.post
      .in("payments")
      .in(jsonBody[CreatePaymentRequest])
      .out(jsonBody[PaymentResponse])

  val routes: ZServerEndpoint[Any, Any] =
    createPaymentRequest
      .zServerLogic { request =>
        {
          val response =
            PaymentResponse(
              paymentId = UUID.randomUUID().toString(),
              merchantId = request.merchantId,
              amount = request.amount,
              status = "PENDING"
            )

          ZIO.succeed(response)
        }
      }

}
