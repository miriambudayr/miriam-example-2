// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.client

import com.configure_me_miriam_example_2.api.core.ClientOptions
import com.configure_me_miriam_example_2.api.core.getPackageVersion
import com.configure_me_miriam_example_2.api.services.async.PetServiceAsync
import com.configure_me_miriam_example_2.api.services.async.PetServiceAsyncImpl

class MiriamExample2ClientAsyncImpl(private val clientOptions: ClientOptions) :
    MiriamExample2ClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: MiriamExample2Client by lazy { MiriamExample2ClientImpl(clientOptions) }

    private val withRawResponse: MiriamExample2ClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): MiriamExample2Client = sync

    override fun withRawResponse(): MiriamExample2ClientAsync.WithRawResponse = withRawResponse

    override fun pets(): PetServiceAsync = pets

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MiriamExample2ClientAsync.WithRawResponse {

        private val pets: PetServiceAsync.WithRawResponse by lazy {
            PetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun pets(): PetServiceAsync.WithRawResponse = pets
    }
}
