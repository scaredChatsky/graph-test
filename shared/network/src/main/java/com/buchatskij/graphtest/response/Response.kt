package com.buchatskij.graphtest.response

data class Response<ResponseType>(
    val response: ResponseType?
)

class UnexpectedError(message: String) : Exception(message)