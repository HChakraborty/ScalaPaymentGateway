package paymentgateway.payment.model

import zio.json.* 

enum PaymentStatus derives JsonCodec {
    case PENDING
    case CAPTURED
    case CANCELLED
    case REFUNDED
}