package paymentgateway.payment.model

import zio.json.JsonCodec

final case class CreatePaymentRequest(
    merchantId: String,
    amount: BigDecimal
) derives JsonCodec