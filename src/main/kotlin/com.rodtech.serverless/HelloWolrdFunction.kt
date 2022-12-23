package com.rodtech.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import org.apache.log4j.Logger

class HelloWolrdFunction : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

    companion object {
        private val log = Logger.getLogger(HelloWolrdFunction::class.java)
    }

    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context?): APIGatewayProxyResponseEvent {
        log.info("received: $input")
        return APIGatewayProxyResponseEvent().apply {
            statusCode = 200
            body = "Hello World"
        }
    }

}