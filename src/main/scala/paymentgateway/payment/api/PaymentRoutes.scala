package paymentgateway.payment.api

import sttp.tapir.ztapir.*

import paymentgateway.payment.service.PaymentService
import paymentgateway.payment.api.PaymentEndpoints.*
import paymentgateway.payment.api.PaymentErrorMapper.toResponse

object PaymentRoutes {

  private val createPaymentRoute =
    createPaymentRequest
      .zServerLogic[Any] { request =>
        {
          PaymentService
            .createPayment(request)
            .mapError(toResponse)
        }
      }

  private val getPaymentByIdRoute =
    getPaymentByIdRequest
      .zServerLogic[Any] { paymentId =>
        {
          PaymentService
            .getPaymentById(paymentId)
            .mapError(toResponse)
        }
      }

  private val getAllPaymentsRoute =
    getAllPaymentsRequest
      .zServerLogic[Any] { _ =>
        PaymentService
          .getAllPayments()
          .mapError(toResponse)
      }

  val routes: List[ZServerEndpoint[Any, Any]] =
    List(
      createPaymentRoute.widen,
      getPaymentByIdRoute.widen,
      getAllPaymentsRoute.widen
    )

}
