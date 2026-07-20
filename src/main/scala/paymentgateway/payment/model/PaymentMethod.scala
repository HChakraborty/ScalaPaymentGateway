package paymentgateway.payment.model

import zio.json.*
import sttp.tapir.Schema
import sttp.tapir.Validator

enum PaymentMethod derives JsonCodec:
    case Card
    case UPI
    case BankTransfer

object PaymentMethod {
  given Schema[PaymentMethod] =
    Schema.derivedEnumeration[PaymentMethod].defaultStringBased
}