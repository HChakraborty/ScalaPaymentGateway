package paymentgateway.payment.api

import sttp.tapir.ztapir.*

import paymentgateway.payment.service.PaymentService
import paymentgateway.payment.api.PaymentEndpoints.*
import paymentgateway.payment.api.PaymentErrorMapper.toResponse

object PaymentRoutes {

  private val createPaymentRoute =
    createPaymentRequest
      .zServerLogic { payment =>
        {
          PaymentService
            .createPayment(payment)
            .mapError(toResponse)
        }
      }

  private val getPaymentByIdRoute =
    getPaymentByIdRequest
      .zServerLogic { paymentId =>
        {
          PaymentService
            .getPaymentById(paymentId)
            .mapError(toResponse)
        }
      }

  private val getAllPaymentsRoute =
    getAllPaymentsRequest
      .zServerLogic { _ =>
        PaymentService
          .getAllPayments()
          .mapError(toResponse)
      }

  val routes =
    List(
      createPaymentRoute,
      getPaymentByIdRoute,
      getAllPaymentsRoute
    )

}
