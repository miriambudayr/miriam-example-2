// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.models.pets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PetCreateParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        PetCreateParams.builder().newPet(NewPet.builder().name("name").tag("tag").build()).build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            PetCreateParams.builder()
                .newPet(NewPet.builder().name("name").tag("tag").build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(NewPet.builder().name("name").tag("tag").build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = PetCreateParams.builder().newPet(NewPet.builder().name("name").build()).build()

        val body = params._body()

        assertThat(body).isEqualTo(NewPet.builder().name("name").build())
    }
}
