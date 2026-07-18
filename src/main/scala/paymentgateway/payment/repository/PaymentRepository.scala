package paymentgateway.payment.repository

import paymentgateway.payment.model.PaymentResponse
import zio.*

trait PaymentRepository {

  def create(
      response: PaymentResponse
  ): Task[PaymentResponse]

  def findById(
      paymentId: String
  ): Task[Option[PaymentResponse]]

  def findAll(): Task[List[PaymentResponse]]

}
