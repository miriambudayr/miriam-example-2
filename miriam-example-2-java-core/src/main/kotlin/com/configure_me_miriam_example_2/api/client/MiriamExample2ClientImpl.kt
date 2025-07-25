// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.client

import com.configure_me_miriam_example_2.api.core.ClientOptions
import com.configure_me_miriam_example_2.api.core.getPackageVersion
import com.configure_me_miriam_example_2.api.services.blocking.PetService
import com.configure_me_miriam_example_2.api.services.blocking.PetServiceImpl
import java.util.function.Consumer

class MiriamExample2ClientImpl(private val clientOptions: ClientOptions) : MiriamExample2Client {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: MiriamExample2ClientAsync by lazy {
        MiriamExample2ClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: MiriamExample2Client.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): MiriamExample2ClientAsync = async

    override fun withRawResponse(): MiriamExample2Client.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MiriamExample2Client =
        MiriamExample2ClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pets(): PetService = pets

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MiriamExample2Client.WithRawResponse {

        private val pets: PetService.WithRawResponse by lazy {
            PetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MiriamExample2Client.WithRawResponse =
            MiriamExample2ClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pets(): PetService.WithRawResponse = pets
    }
}
