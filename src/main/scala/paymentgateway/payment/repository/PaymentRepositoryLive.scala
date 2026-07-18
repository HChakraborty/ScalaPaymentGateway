package paymentgateway.payment.repository

import zio.* 

import scala.collection.mutable.ListBuffer
import paymentgateway.payment.model.PaymentResponse

object PaymentRepositoryLive extends PaymentRepository {

    private val payments =
        ListBuffer.empty[PaymentResponse]

    override def create(
        payment: PaymentResponse
    ): Task[PaymentResponse] = {
        payments += payment
        ZIO.succeed(payment)
    }

    override def findById(
        paymentId: String
    ): Task[Option[PaymentResponse]] = {
        ZIO.succeed(
            payments.find(_.paymentId == paymentId)
        )
    }

    override def findAll(): Task[List[PaymentResponse]] = {
        ZIO.succeed(
            payments.toList
        )
    }

}