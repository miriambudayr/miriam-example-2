// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.services.blocking

import com.configure_me_miriam_example_2.api.TestServerExtension
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient
import com.configure_me_miriam_example_2.api.models.pets.NewPet
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams
import com.configure_me_miriam_example_2.api.models.pets.PetListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PetServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            MiriamExample2OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pet =
            petService.create(
                PetCreateParams.builder()
                    .newPet(NewPet.builder().name("name").tag("tag").build())
                    .build()
            )

        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            MiriamExample2OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pet = petService.retrieve(0L)

        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            MiriamExample2OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pets = petService.list(PetListParams.builder().limit(0).addTag("string").build())

        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            MiriamExample2OkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        petService.delete(0L)
    }
}
