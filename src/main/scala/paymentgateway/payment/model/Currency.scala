package paymentgateway.payment.model

import zio.json.*
import sttp.tapir.Schema
import sttp.tapir.Validator

enum Currency derives JsonCodec:
    case INR
    case USD
    case EUR
    case JPY

object Currency {
  given Schema[Currency] =
    Schema.derivedEnumeration[Currency].defaultStringBased
}