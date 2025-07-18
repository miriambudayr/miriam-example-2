// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.services.async

import com.configure_me_miriam_example_2.api.core.ClientOptions
import com.configure_me_miriam_example_2.api.core.RequestOptions
import com.configure_me_miriam_example_2.api.core.checkRequired
import com.configure_me_miriam_example_2.api.core.handlers.emptyHandler
import com.configure_me_miriam_example_2.api.core.handlers.errorBodyHandler
import com.configure_me_miriam_example_2.api.core.handlers.errorHandler
import com.configure_me_miriam_example_2.api.core.handlers.jsonHandler
import com.configure_me_miriam_example_2.api.core.http.HttpMethod
import com.configure_me_miriam_example_2.api.core.http.HttpRequest
import com.configure_me_miriam_example_2.api.core.http.HttpResponse
import com.configure_me_miriam_example_2.api.core.http.HttpResponse.Handler
import com.configure_me_miriam_example_2.api.core.http.HttpResponseFor
import com.configure_me_miriam_example_2.api.core.http.json
import com.configure_me_miriam_example_2.api.core.http.parseable
import com.configure_me_miriam_example_2.api.core.prepareAsync
import com.configure_me_miriam_example_2.api.models.pets.Pet
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams
import com.configure_me_miriam_example_2.api.models.pets.PetDeleteParams
import com.configure_me_miriam_example_2.api.models.pets.PetListParams
import com.configure_me_miriam_example_2.api.models.pets.PetRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PetServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PetServiceAsync {

    private val withRawResponse: PetServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PetServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PetServiceAsync =
        PetServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: PetCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Pet> =
        // post /pets
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: PetRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Pet> =
        // get /pets/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: PetListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<List<Pet>> =
        // get /pets
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: PetDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /pets/{id}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PetServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PetServiceAsync.WithRawResponse =
            PetServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Pet> = jsonHandler<Pet>(clientOptions.jsonMapper)

        override fun create(
            params: PetCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Pet>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("pets")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<Pet> = jsonHandler<Pet>(clientOptions.jsonMapper)

        override fun retrieve(
            params: PetRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Pet>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("pets", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<List<Pet>> =
            jsonHandler<List<Pet>>(clientOptions.jsonMapper)

        override fun list(
            params: PetListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<List<Pet>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("pets")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.forEach { it.validate() }
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: PetDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("pets", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }
    }
}
