package paymentgateway.infrastructure.http

import zio._
import zio.http._

object HttpServer {

    val app: Routes[Any, Response] = 
        Routes(
            Method.GET / "" ->
                handler(
                    Response.text("The Payment Gateway server is running")
                )
        )

}