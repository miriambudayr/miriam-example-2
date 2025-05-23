// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.models.pets

import com.configure_me_miriam_example_2.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PetTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val pet = Pet.builder().name("name").tag("tag").id(0L).build()

        assertThat(pet.name()).isEqualTo("name")
        assertThat(pet.tag()).contains("tag")
        assertThat(pet.id()).isEqualTo(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pet = Pet.builder().name("name").tag("tag").id(0L).build()

        val roundtrippedPet =
            jsonMapper.readValue(jsonMapper.writeValueAsString(pet), jacksonTypeRef<Pet>())

        assertThat(roundtrippedPet).isEqualTo(pet)
    }
}
