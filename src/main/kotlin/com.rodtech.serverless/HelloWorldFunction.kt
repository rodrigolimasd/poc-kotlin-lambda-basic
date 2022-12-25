package com.rodtech.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.rodtech.serverless.response.ApiGatewayResponse

//import java.util.logging.Logger

//import org.apache.log4j.Logger

class HelloWorldFunction : RequestHandler<Map<String, Any>, ApiGatewayResponse>{

    companion object {
       // private val log = Logger.getAnonymousLogger() //Logger.getLogger(HelloWorldFunction::class.java)
    }

    override fun handleRequest(input: Map<String, Any>, context: Context?): ApiGatewayResponse {
       // log.info("received: $input")
        return ApiGatewayResponse(
            body = "Hello World"
        )
    }

}