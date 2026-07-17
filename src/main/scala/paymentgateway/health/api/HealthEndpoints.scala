package paymentgateway.health.api

import sttp.tapir.ztapir.*

object HealthEndpoints {

    val healthEndpoint = 
        endpoint
            .get
            .in("health")
            .out(stringBody)

}