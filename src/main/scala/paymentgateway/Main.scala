package paymentgateway

import zio._
import zio.Console._

object Main extends ZIOAppDefault {

    override def run: ZIO[ZIOAppArgs & Scope, Any, Any] = startup

    val startup = 
        for {
      _ <- printLine("===================================")
      _ <- printLine("   Scala Payment Gateway")
      _ <- printLine("===================================")
      _ <- printLine("")
      _ <- printLine("Welcome!")
      _ <- printLine("Please enter your name:")
      name <- readLine
      _ <- printLine(s"Hello $name!")
      _ <- printLine("The Payment Gateway is starting...")
        } yield()

}