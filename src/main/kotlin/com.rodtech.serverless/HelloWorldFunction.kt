package com.rodtech.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.rodtech.serverless.response.ApiGatewayResponse
import com.rodtech.serverless.response.HelloResponse
import org.apache.logging.log4j.LogManager

class HelloWorldFunction:RequestHandler<Map<String, Any>, ApiGatewayResponse>{
    override fun handleRequest(input:Map<String, Any>, context: Context):ApiGatewayResponse {
        log.info("received: ${input.keys}")
        return ApiGatewayResponse.build {
            statusCode = 200
            objectBody = HelloResponse("Go Serverless v1.x! Your Kotlin function executed successfully!", input)
            headers = mapOf("X-Powered-By" to "AWS Lambda & serverless")
        }
    }

    companion object {
        private val log = LogManager.getLogger(HelloWorldFunction::class.java)
    }

}