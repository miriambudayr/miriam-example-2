// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.services.async

import com.configure_me_miriam_example_2.api.TestServerExtension
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClientAsync
import com.configure_me_miriam_example_2.api.models.pets.NewPet
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams
import com.configure_me_miriam_example_2.api.models.pets.PetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PetServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            MiriamExample2OkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petFuture =
            petServiceAsync.create(
                PetCreateParams.builder()
                    .newPet(NewPet.builder().name("name").tag("tag").build())
                    .build()
            )

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            MiriamExample2OkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petFuture = petServiceAsync.retrieve(0L)

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            MiriamExample2OkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petsFuture =
            petServiceAsync.list(PetListParams.builder().limit(0).addTag("string").build())

        val pets = petsFuture.get()
        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            MiriamExample2OkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val future = petServiceAsync.delete(0L)

        val response = future.get()
    }
}
