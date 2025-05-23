// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.errors

import com.configure_me_miriam_example_2.api.core.JsonValue
import com.configure_me_miriam_example_2.api.core.http.Headers

abstract class MiriamExample2ServiceException
protected constructor(message: String, cause: Throwable? = null) :
    MiriamExample2Exception(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
