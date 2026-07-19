package paymentgateway.payment.repository

import paymentgateway.payment.model.*

import zio.*

trait PaymentRepository {

  def create(
      payment: Payment
  ): IO[PaymentError, Payment]

  def findById(
      paymentId: String
  ): IO[PaymentError, Payment]

  def findAll(): IO[PaymentError, List[Payment]]

}

object PaymentRepository {

  def create(
      payment: Payment
  ): ZIO[PaymentRepository, PaymentError, Payment] =
    ZIO.serviceWithZIO[PaymentRepository](
      _.create(payment)
    )

  def findById(
      paymentId: String
  ): ZIO[PaymentRepository, PaymentError, Payment] =
    ZIO.serviceWithZIO[PaymentRepository](
      _.findById(paymentId)
    )

  def findAll(): ZIO[PaymentRepository, PaymentError, List[Payment]] =
    ZIO.serviceWithZIO[PaymentRepository](
      _.findAll()
    )

}
