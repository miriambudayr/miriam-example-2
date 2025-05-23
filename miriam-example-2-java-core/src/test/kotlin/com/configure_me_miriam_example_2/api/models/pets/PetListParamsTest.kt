// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.models.pets

import com.configure_me_miriam_example_2.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PetListParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        PetListParams.builder().limit(0).addTag("string").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params = PetListParams.builder().limit(0).addTag("string").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "0")
                    .put("tags", listOf("string").joinToString(","))
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = PetListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
