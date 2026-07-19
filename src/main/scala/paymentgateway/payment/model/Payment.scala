package paymentgateway.payment.model

import zio.json.JsonCodec
import java.time.Instant

final case class Payment(
    paymentId: String,
    merchantId: String,
    money: Money,
    paymentMethod: PaymentMethod,
    status: PaymentStatus,
    createdAt: Instant,
    updatedAt: Instant
) derives JsonCodec