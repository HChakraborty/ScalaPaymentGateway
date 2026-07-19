package paymentgateway.payment.model

import zio.json.*
import sttp.tapir.Schema

enum Currency derives JsonCodec:
    case INR
    case USD
    case EUR
    case JPY
