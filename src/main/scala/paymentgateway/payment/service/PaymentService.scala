package paymentgateway.payment.service

import paymentgateway.payment.model._

import zio.*

import java.util.UUID
import paymentgateway.payment.repository.PaymentRepositoryLive

object PaymentService {
  def createPayment(
      request: CreatePaymentRequest
  ): IO[PaymentError, PaymentResponse] = {

    val response =
      PaymentResponse(
        paymentId = UUID.randomUUID().toString(),
        merchantId = request.merchantId,
        amount = request.amount,
        status = "PENDING"
      )

    PaymentRepositoryLive.create(response)

    ZIO.succeed(response)

  }

  def getPaymentById(
    paymentId: String
  ): IO[PaymentError, PaymentResponse] = {
    PaymentRepositoryLive.findById(paymentId)
  }

  def getAllPayments(): IO[PaymentError, List[PaymentResponse]] = PaymentRepositoryLive.findAll()
}
