// File generated from our OpenAPI spec by Stainless.

package com.configure_me_miriam_example_2.api.models.pets

import com.configure_me_miriam_example_2.api.core.ExcludeMissing
import com.configure_me_miriam_example_2.api.core.JsonField
import com.configure_me_miriam_example_2.api.core.JsonMissing
import com.configure_me_miriam_example_2.api.core.JsonValue
import com.configure_me_miriam_example_2.api.core.checkRequired
import com.configure_me_miriam_example_2.api.errors.MiriamExample2InvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional

class Pet
private constructor(
    private val name: JsonField<String>,
    private val tag: JsonField<String>,
    private val id: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tag") @ExcludeMissing tag: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<Long> = JsonMissing.of(),
    ) : this(name, tag, id, mutableMapOf())

    fun toNewPet(): NewPet = NewPet.builder().name(name).tag(tag).build()

    /**
     * Name of the pet
     *
     * @throws MiriamExample2InvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Type of the pet
     *
     * @throws MiriamExample2InvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tag(): Optional<String> = tag.getOptional("tag")

    /**
     * Unique id of the pet
     *
     * @throws MiriamExample2InvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): Long = id.getRequired("id")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [tag].
     *
     * Unlike [tag], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tag") @ExcludeMissing fun _tag(): JsonField<String> = tag

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Long> = id

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Pet].
         *
         * The following fields are required:
         * ```java
         * .name()
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Pet]. */
    class Builder internal constructor() {

        private var name: JsonField<String>? = null
        private var tag: JsonField<String> = JsonMissing.of()
        private var id: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(pet: Pet) = apply {
            name = pet.name
            tag = pet.tag
            id = pet.id
            additionalProperties = pet.additionalProperties.toMutableMap()
        }

        /** Name of the pet */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Type of the pet */
        fun tag(tag: String) = tag(JsonField.of(tag))

        /**
         * Sets [Builder.tag] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tag] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tag(tag: JsonField<String>) = apply { this.tag = tag }

        /** Unique id of the pet */
        fun id(id: Long) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Long] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Long>) = apply { this.id = id }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [Pet].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .name()
         * .id()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Pet =
            Pet(
                checkRequired("name", name),
                tag,
                checkRequired("id", id),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Pet = apply {
        if (validated) {
            return@apply
        }

        name()
        tag()
        id()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: MiriamExample2InvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (name.asKnown().isPresent) 1 else 0) +
            (if (tag.asKnown().isPresent) 1 else 0) +
            (if (id.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Pet && name == other.name && tag == other.tag && id == other.id && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(name, tag, id, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Pet{name=$name, tag=$tag, id=$id, additionalProperties=$additionalProperties}"
}
