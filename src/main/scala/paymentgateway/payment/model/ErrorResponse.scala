package paymentgateway.payment.model

import zio.json.*

final case class ErrorResponse(
    code: String,
    message: String
) derives JsonEncoder, JsonDecoder