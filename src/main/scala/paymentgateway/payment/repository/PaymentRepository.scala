package paymentgateway.payment.repository

import paymentgateway.payment.model.*

import zio.*

trait PaymentRepository {

  def create(
      response: PaymentResponse
  ): IO[PaymentError, PaymentResponse]

  def findById(
      paymentId: String
  ): IO[PaymentError, PaymentResponse]

  def findAll(): IO[PaymentError, List[PaymentResponse]]

}
