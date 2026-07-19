package paymentgateway.payment.service

import paymentgateway.payment.model._

import zio.*

import java.util.UUID
import paymentgateway.payment.repository.PaymentRepository
import java.time.Instant

object PaymentService {
  def createPayment(
      request: CreatePaymentRequest
  ): ZIO[PaymentRepository, PaymentError, Payment] = {

    if (request.amount <= 0)
      ZIO.fail(PaymentError.InvalidAmount)
    else {
      val payment =
        Payment(
          paymentId = UUID.randomUUID().toString(),
          merchantId = request.merchantId,
          money = Money(
            request.amount,
            request.currency
          ),
          paymentMethod = request.paymentMethod,
          status = PaymentStatus.PENDING,
          createdAt = Instant.now(),
          updatedAt = Instant.now()
        )

      PaymentRepository.create(payment)
    }

  }

  def getPaymentById(
      paymentId: String
  ): ZIO[PaymentRepository, PaymentError, Payment] = {
    PaymentRepository.findById(paymentId)
  }

  def getAllPayments(): ZIO[PaymentRepository, PaymentError, List[Payment]] =
    PaymentRepository.findAll()
}
