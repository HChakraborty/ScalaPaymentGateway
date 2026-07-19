package paymentgateway.payment.model

import zio.json.*

final case class Money (
    amount: BigDecimal,
    currency: Currency
) derives JsonCodec