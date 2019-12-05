package com.buchatskij.graphtest.response

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ResponseDeserializer : JsonDeserializer<Response<Any>> {

    companion object {
        private const val RESULT_FIELD = "result"
        private const val RESPONSE_FIELD = "response"
        private const val MESSAGE_FIELD = "message"
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): Response<Any> {
        if (json == null) {
            return Response(null)
        }

        val jsonObject = json.asJsonObject

        var jsonResponse: JsonObject? = null
        if (jsonObject.has(RESPONSE_FIELD)) {
            jsonResponse = jsonObject.getAsJsonObject(RESPONSE_FIELD)
        }

        var resultStatus = 0
        var errorMessage = ""
        if (jsonObject.has(RESULT_FIELD)) {
            resultStatus = jsonObject.get(RESULT_FIELD).asInt
        } else if (jsonResponse != null && jsonResponse.has(RESULT_FIELD)) {
            with(jsonResponse) {
                resultStatus = get(RESULT_FIELD).asInt
                errorMessage = get(MESSAGE_FIELD).asString
            }
        }

        return if (resultStatus == 0) {
            val typeParameters: Array<Type> = (typeOfT as ParameterizedType).actualTypeArguments
            Response(context.deserialize<Any>(jsonResponse, typeParameters[0]))
        } else {
            throw UnexpectedError(errorMessage)
        }
    }
}
