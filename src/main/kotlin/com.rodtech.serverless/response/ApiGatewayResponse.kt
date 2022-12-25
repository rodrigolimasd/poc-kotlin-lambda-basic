package com.rodtech.serverless.response

data class ApiGatewayResponse(
    val statusCode: Int = 200,
    val body: String,
    val headers: Map<String, String> = emptyMap(),
    val isBase64Encoded: Boolean = false
)