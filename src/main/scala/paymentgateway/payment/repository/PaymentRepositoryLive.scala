package paymentgateway.payment.repository

import zio.* 

import scala.collection.mutable.ListBuffer

import paymentgateway.payment.model.*


object PaymentRepositoryLive extends PaymentRepository {

    private val payments =
        ListBuffer.empty[PaymentResponse]

    override def create(
        payment: PaymentResponse
    ): IO[PaymentError, PaymentResponse] = {
        payments += payment
        ZIO.succeed(payment)
    }

    override def findById(
        paymentId: String
    ): IO[PaymentError, PaymentResponse] = {
       
        payments.find(_.paymentId == paymentId) match
            case Some(payment) =>
                ZIO.succeed(payment)
            case None => 
                ZIO.fail(PaymentError.PaymentNotFound) 
        
    }

    override def findAll(): IO[PaymentError, List[PaymentResponse]]= {
        ZIO.succeed(
            payments.toList
        )
    }

}