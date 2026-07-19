package paymentgateway.payment.repository

import zio.*

import scala.collection.mutable.ListBuffer

import paymentgateway.payment.model.*

final case class PaymentRepositoryLive(
    payments: ListBuffer[Payment]
) extends PaymentRepository {

  override def create(
      payment: Payment
  ): IO[PaymentError, Payment] = {
    payments += payment
    ZIO.succeed(payment)
  }

  override def findById(
      paymentId: String
  ): IO[PaymentError, Payment] = {

    payments.find(_.paymentId == paymentId) match
      case Some(payment) =>
        ZIO.succeed(payment)
      case None =>
        ZIO.fail(PaymentError.PaymentNotFound)

  }

  override def findAll(): IO[PaymentError, List[Payment]] = {
    ZIO.succeed(
      payments.toList
    )
  }

}

object PaymentRepositoryLive {

  var layer: ULayer[PaymentRepository] =
    ZLayer.succeed(
      PaymentRepositoryLive(
        ListBuffer.empty
      )
    )

}
