package paymentgateway.payment.api

import paymentgateway.payment.model.*

import sttp.tapir.ztapir.*
import sttp.tapir.json.zio.*
import sttp.tapir.generic.auto.*

import zio.*

import java.util.UUID
import paymentgateway.payment.service.PaymentService

object PaymentEndpoints {

  val createPaymentRequest =
    endpoint.post
      .in("payments")
      .in(jsonBody[CreatePaymentRequest])
      .out(jsonBody[PaymentResponse])

  val routes: ZServerEndpoint[Any, Any] =
    createPaymentRequest
      .zServerLogic { request =>
        {
          PaymentService.createPayment(request).mapError(_ => ())
        }
      }

}
