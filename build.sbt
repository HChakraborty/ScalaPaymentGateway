ThisBuild / scalaVersion := "3.7.3"

lazy val root = (project in file("."))
    .settings(
        name := "ScalaPaymentGateway",
        version := "0.1.0"
    )

libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % "2.1.26",
    "dev.zio" %% "zio-http" % "3.8.1",

    "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % "1.13.28",
    "com.softwaremill.sttp.tapir" %% "tapir-json-zio" % "1.13.28",
    "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % "1.13.28"
)