package com.rodtech.serverless.response

data class HelloResponse(val message: String, val input: Map<String, Any>) : Response()
