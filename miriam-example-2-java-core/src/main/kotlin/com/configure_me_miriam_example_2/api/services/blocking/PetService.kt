// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.services.blocking

import com.configure_me_miriam_example_2.api.core.ClientOptions
import com.configure_me_miriam_example_2.api.core.RequestOptions
import com.configure_me_miriam_example_2.api.core.http.HttpResponse
import com.configure_me_miriam_example_2.api.core.http.HttpResponseFor
import com.configure_me_miriam_example_2.api.models.pets.Pet
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams
import com.configure_me_miriam_example_2.api.models.pets.PetDeleteParams
import com.configure_me_miriam_example_2.api.models.pets.PetListParams
import com.configure_me_miriam_example_2.api.models.pets.PetRetrieveParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface PetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PetService

    /** Creates a new pet in the store. Duplicates are allowed */
    fun create(params: PetCreateParams): Pet = create(params, RequestOptions.none())

    /** @see create */
    fun create(params: PetCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** Returns a pet based on a single ID */
    fun retrieve(id: Long): Pet = retrieve(id, PetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: Long,
        params: PetRetrieveParams = PetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Pet = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(id: Long, params: PetRetrieveParams = PetRetrieveParams.none()): Pet =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: PetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Pet

    /** @see retrieve */
    fun retrieve(params: PetRetrieveParams): Pet = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: Long, requestOptions: RequestOptions): Pet =
        retrieve(id, PetRetrieveParams.none(), requestOptions)

    /**
     * Returns all pets from the system that the user has access to Nam sed condimentum est.
     * Maecenas tempor sagittis sapien, nec rhoncus sem sagittis sit amet. Aenean at gravida augue,
     * ac iaculis sem. Curabitur odio lorem, ornare eget elementum nec, cursus id lectus. Duis mi
     * turpis, pulvinar ac eros ac, tincidunt varius justo. In hac habitasse platea dictumst.
     * Integer at adipiscing ante, a sagittis ligula. Aenean pharetra tempor ante molestie
     * imperdiet. Vivamus id aliquam diam. Cras quis velit non tortor eleifend sagittis. Praesent at
     * enim pharetra urna volutpat venenatis eget eget mauris. In eleifend fermentum facilisis.
     * Praesent enim enim, gravida ac sodales sed, placerat id erat. Suspendisse lacus dolor,
     * consectetur non augue vel, vehicula interdum libero. Morbi euismod sagittis libero sed
     * lacinia.
     *
     * Sed tempus felis lobortis leo pulvinar rutrum. Nam mattis velit nisl, eu condimentum ligula
     * luctus nec. Phasellus semper velit eget aliquet faucibus. In a mattis elit. Phasellus vel
     * urna viverra, condimentum lorem id, rhoncus nibh. Ut pellentesque posuere elementum. Sed a
     * varius odio. Morbi rhoncus ligula libero, vel eleifend nunc tristique vitae. Fusce et sem
     * dui. Aenean nec scelerisque tortor. Fusce malesuada accumsan magna vel tempus. Quisque mollis
     * felis eu dolor tristique, sit amet auctor felis gravida. Sed libero lorem, molestie sed nisl
     * in, accumsan tempor nisi. Fusce sollicitudin massa ut lacinia mattis. Sed vel eleifend lorem.
     * Pellentesque vitae felis pretium, pulvinar elit eu, euismod sapien.
     */
    fun list(): List<Pet> = list(PetListParams.none())

    /** @see list */
    fun list(
        params: PetListParams = PetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Pet>

    /** @see list */
    fun list(params: PetListParams = PetListParams.none()): List<Pet> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): List<Pet> = list(PetListParams.none(), requestOptions)

    /** deletes a single pet based on the ID supplied */
    fun delete(id: Long) = delete(id, PetDeleteParams.none())

    /** @see delete */
    fun delete(
        id: Long,
        params: PetDeleteParams = PetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: Long, params: PetDeleteParams = PetDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: PetDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: PetDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: Long, requestOptions: RequestOptions) =
        delete(id, PetDeleteParams.none(), requestOptions)

    /** A view of [PetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): PetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /pets`, but is otherwise the same as
         * [PetService.create].
         */
        @MustBeClosed
        fun create(params: PetCreateParams): HttpResponseFor<Pet> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: PetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet>

        /**
         * Returns a raw HTTP response for `get /pets/{id}`, but is otherwise the same as
         * [PetService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: Long): HttpResponseFor<Pet> = retrieve(id, PetRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: Long,
            params: PetRetrieveParams = PetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: Long,
            params: PetRetrieveParams = PetRetrieveParams.none(),
        ): HttpResponseFor<Pet> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: PetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Pet>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: PetRetrieveParams): HttpResponseFor<Pet> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: Long, requestOptions: RequestOptions): HttpResponseFor<Pet> =
            retrieve(id, PetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /pets`, but is otherwise the same as
         * [PetService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<List<Pet>> = list(PetListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: PetListParams = PetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Pet>>

        /** @see list */
        @MustBeClosed
        fun list(params: PetListParams = PetListParams.none()): HttpResponseFor<List<Pet>> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<List<Pet>> =
            list(PetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /pets/{id}`, but is otherwise the same as
         * [PetService.delete].
         */
        @MustBeClosed fun delete(id: Long): HttpResponse = delete(id, PetDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: Long,
            params: PetDeleteParams = PetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(id: Long, params: PetDeleteParams = PetDeleteParams.none()): HttpResponse =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: PetDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: Long, requestOptions: RequestOptions): HttpResponse =
            delete(id, PetDeleteParams.none(), requestOptions)
    }
}
