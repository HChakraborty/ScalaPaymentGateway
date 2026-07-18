package paymentgateway.payment.model

sealed trait PaymentError

object PaymentError {
    
    case object InvalidAmount extends PaymentError

    case object PaymentNotFound extends PaymentError

}