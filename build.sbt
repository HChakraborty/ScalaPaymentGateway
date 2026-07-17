ThisBuild / scalaVersion := "3.7.3"

lazy val root = (project in file("."))
    .settings(
        name := "ScalaPaymentGateway",
        version := "0.1.0"
    )

libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % "2.1.26"
)