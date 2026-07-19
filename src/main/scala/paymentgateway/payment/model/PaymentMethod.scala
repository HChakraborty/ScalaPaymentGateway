package paymentgateway.payment.model

import zio.json.*
import sttp.tapir.Schema

enum PaymentMethod derives JsonCodec:
    case Card
    case UPI
    case BankTransfer
