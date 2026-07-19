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
      .errorOut(jsonBody[ErrorResponse])
      .out(jsonBody[Payment])

  val getPaymentByIdRequest =
    endpoint.get
      .in("payments" / path[String]("paymentId"))
      .errorOut(jsonBody[ErrorResponse])
      .out(jsonBody[Payment])

  val getAllPaymentsRequest =
    endpoint.get
      .in("payments")
      .errorOut(jsonBody[ErrorResponse])
      .out(jsonBody[List[Payment]])

}
