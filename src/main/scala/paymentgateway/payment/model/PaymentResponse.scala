package paymentgateway.payment.model

import zio.json.JsonCodec

final case class PaymentResponse(
    paymentId: String,
    merchantId: String,
    amount: BigDecimal,
    status: String
) derives JsonCodec