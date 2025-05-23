@file:JvmName("JsonHandler")

package com.configure_me_miriam_example_2.api.core.handlers

import com.configure_me_miriam_example_2.api.core.http.HttpResponse
import com.configure_me_miriam_example_2.api.core.http.HttpResponse.Handler
import com.configure_me_miriam_example_2.api.errors.MiriamExample2InvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw MiriamExample2InvalidDataException("Error reading response", e)
            }
    }
