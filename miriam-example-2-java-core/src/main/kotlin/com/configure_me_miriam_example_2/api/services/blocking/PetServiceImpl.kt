// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.services.blocking

import com.configure_me_miriam_example_2.api.core.ClientOptions
import com.configure_me_miriam_example_2.api.core.JsonValue
import com.configure_me_miriam_example_2.api.core.RequestOptions
import com.configure_me_miriam_example_2.api.core.checkRequired
import com.configure_me_miriam_example_2.api.core.handlers.emptyHandler
import com.configure_me_miriam_example_2.api.core.handlers.errorHandler
import com.configure_me_miriam_example_2.api.core.handlers.jsonHandler
import com.configure_me_miriam_example_2.api.core.handlers.withErrorHandler
import com.configure_me_miriam_example_2.api.core.http.HttpMethod
import com.configure_me_miriam_example_2.api.core.http.HttpRequest
import com.configure_me_miriam_example_2.api.core.http.HttpResponse
import com.configure_me_miriam_example_2.api.core.http.HttpResponse.Handler
import com.configure_me_miriam_example_2.api.core.http.HttpResponseFor
import com.configure_me_miriam_example_2.api.core.http.json
import com.configure_me_miriam_example_2.api.core.http.parseable
import com.configure_me_miriam_example_2.api.core.prepare
import com.configure_me_miriam_example_2.api.models.pets.Pet
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams
import com.configure_me_miriam_example_2.api.models.pets.PetDeleteParams
import com.configure_me_miriam_example_2.api.models.pets.PetListParams
import com.configure_me_miriam_example_2.api.models.pets.PetRetrieveParams
import kotlin.jvm.optionals.getOrNull

class PetServiceImpl internal constructor(private val clientOptions: ClientOptions) : PetService {

    private val withRawResponse: PetService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PetService.WithRawResponse = withRawResponse

    override fun create(params: PetCreateParams, requestOptions: RequestOptions): Pet =
        // post /pets
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: PetRetrieveParams, requestOptions: RequestOptions): Pet =
        // get /pets/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: PetListParams, requestOptions: RequestOptions): List<Pet> =
        // get /pets
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: PetDeleteParams, requestOptions: RequestOptions) {
        // delete /pets/{id}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PetService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Pet> =
            jsonHandler<Pet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: PetCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Pet> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("pets")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Pet> =
            jsonHandler<Pet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: PetRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Pet> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("pets", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<List<Pet>> =
            jsonHandler<List<Pet>>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: PetListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Pet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("pets")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

        override fun delete(params: PetDeleteParams, requestOptions: RequestOptions): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("pets", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }
    }
}
