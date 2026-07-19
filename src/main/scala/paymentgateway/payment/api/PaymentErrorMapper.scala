package paymentgateway.payment.api

import paymentgateway.payment.model.*
import sttp.tapir.EndpointIO.annotations.statusCode
import sttp.model.StatusCode

object PaymentErrorMapper {

  def toResponse(
      error: PaymentError
  ): ErrorResponse = {
    error match

      case PaymentError.InvalidAmount =>
        ErrorResponse(
          "400",
          "Invalid Amount"
        )

      case PaymentError.PaymentNotFound =>
        ErrorResponse(
          "404",
          "Payment Not Found"
        )

  }

}
