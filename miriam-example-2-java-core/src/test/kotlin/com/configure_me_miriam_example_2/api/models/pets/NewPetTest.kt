// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.models.pets

import com.configure_me_miriam_example_2.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NewPetTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val newPet = NewPet.builder().name("name").tag("tag").build()

        assertThat(newPet.name()).isEqualTo("name")
        assertThat(newPet.tag()).contains("tag")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val newPet = NewPet.builder().name("name").tag("tag").build()

        val roundtrippedNewPet =
            jsonMapper.readValue(jsonMapper.writeValueAsString(newPet), jacksonTypeRef<NewPet>())

        assertThat(roundtrippedNewPet).isEqualTo(newPet)
    }
}
