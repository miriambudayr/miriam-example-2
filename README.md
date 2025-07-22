# Miriam Example 2 Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.configure_me_miriam_example_2.api/miriam-example-2-java)](https://central.sonatype.com/artifact/com.configure_me_miriam_example_2.api/miriam-example-2-java/0.0.1-alpha.0)
[![javadoc](https://javadoc.io/badge2/com.configure_me_miriam_example_2.api/miriam-example-2-java/0.0.1-alpha.0/javadoc.svg)](https://javadoc.io/doc/com.configure_me_miriam_example_2.api/miriam-example-2-java/0.0.1-alpha.0)

<!-- x-release-please-end -->

The Miriam Example 2 Java SDK provides convenient access to the [Miriam Example 2 REST API](https://swagger.iooo) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [swagger.iooo](https://swagger.iooo). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.configure_me_miriam_example_2.api/miriam-example-2-java/0.0.1-alpha.0).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.CONFIGURE_ME_miriam_example_2.api:miriam-example-2-java:0.0.1-alpha.0")
```

### Maven

```xml
<dependency>
  <groupId>com.CONFIGURE_ME_miriam_example_2.api</groupId>
  <artifactId>miriam-example-2-java</artifactId>
  <version>0.0.1-alpha.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;
import com.configure_me_miriam_example_2.api.models.pets.Pet;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;

// Configures using the `miriamexample2.apiKey` and `miriamexample2.baseUrl` system properties
// Or configures using the `MIRIAM_EXAMPLE_2_API_KEY` and `MIRIAM_EXAMPLE_2_BASE_URL` environment variables
MiriamExample2Client client = MiriamExample2OkHttpClient.fromEnv();

List<Pet> pets = client.pets().list();
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

// Configures using the `miriamexample2.apiKey` and `miriamexample2.baseUrl` system properties
// Or configures using the `MIRIAM_EXAMPLE_2_API_KEY` and `MIRIAM_EXAMPLE_2_BASE_URL` environment variables
MiriamExample2Client client = MiriamExample2OkHttpClient.fromEnv();
```

Or manually:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    // Configures using the `miriamexample2.apiKey` and `miriamexample2.baseUrl` system properties
    Or configures using the `MIRIAM_EXAMPLE_2_API_KEY` and `MIRIAM_EXAMPLE_2_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property          | Environment variable        | Required | Default value                       |
| --------- | ------------------------ | --------------------------- | -------- | ----------------------------------- |
| `apiKey`  | `miriamexample2.apiKey`  | `MIRIAM_EXAMPLE_2_API_KEY`  | false    | -                                   |
| `baseUrl` | `miriamexample2.baseUrl` | `MIRIAM_EXAMPLE_2_BASE_URL` | true     | `"https://petstore.swagger.io/api"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;

MiriamExample2Client clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Miriam Example 2 API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.pets().list(...)` should be called with an instance of `PetListParams`, and it will return an instance of `List<Pet>`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;
import com.configure_me_miriam_example_2.api.models.pets.Pet;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `miriamexample2.apiKey` and `miriamexample2.baseUrl` system properties
// Or configures using the `MIRIAM_EXAMPLE_2_API_KEY` and `MIRIAM_EXAMPLE_2_BASE_URL` environment variables
MiriamExample2Client client = MiriamExample2OkHttpClient.fromEnv();

CompletableFuture<List<Pet>> pets = client.async().pets().list();
```

Or create an asynchronous client from the beginning:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2ClientAsync;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClientAsync;
import com.configure_me_miriam_example_2.api.models.pets.Pet;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `miriamexample2.apiKey` and `miriamexample2.baseUrl` system properties
// Or configures using the `MIRIAM_EXAMPLE_2_API_KEY` and `MIRIAM_EXAMPLE_2_BASE_URL` environment variables
MiriamExample2ClientAsync client = MiriamExample2OkHttpClientAsync.fromEnv();

CompletableFuture<List<Pet>> pets = client.pets().list();
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.configure_me_miriam_example_2.api.core.http.Headers;
import com.configure_me_miriam_example_2.api.core.http.HttpResponseFor;
import com.configure_me_miriam_example_2.api.models.pets.Pet;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;

HttpResponseFor<List<Pet>> pets = client.pets().withRawResponse().list();

int statusCode = pets.statusCode();
Headers headers = pets.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.configure_me_miriam_example_2.api.models.pets.Pet;

List<Pet> parsedPets = pets.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`MiriamExample2ServiceException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/MiriamExample2ServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                                                   |
  | ------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/UnexpectedStatusCodeException.kt) |

- [`MiriamExample2IoException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/MiriamExample2IoException.kt): I/O networking errors.

- [`MiriamExample2InvalidDataException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/MiriamExample2InvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`MiriamExample2Exception`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/MiriamExample2Exception.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `MIRIAM_EXAMPLE_2_LOG` environment variable to `info`:

```sh
$ export MIRIAM_EXAMPLE_2_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export MIRIAM_EXAMPLE_2_LOG=debug
```

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`MiriamExample2OkHttpClient`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClient.kt) or [`MiriamExample2OkHttpClientAsync`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.configure_me_miriam_example_2.api.models.pets.Pet;

List<Pet> pets = client.pets().list(RequestOptions.builder().timeout(Duration.ofSeconds(30)).build());
```

Or configure the default for all method calls at the client level:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;
import java.time.Duration;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `miriam-example-2-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`MiriamExample2Client`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2Client.kt), [`MiriamExample2ClientAsync`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientAsync.kt), [`MiriamExample2ClientImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientImpl.kt), and [`MiriamExample2ClientAsyncImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientAsyncImpl.kt), all of which can work with any HTTP client
- `miriam-example-2-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`MiriamExample2OkHttpClient`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClient.kt) and [`MiriamExample2OkHttpClientAsync`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClientAsync.kt), which provide a way to construct [`MiriamExample2ClientImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientImpl.kt) and [`MiriamExample2ClientAsyncImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientAsyncImpl.kt), respectively, using OkHttp
- `miriam-example-2-java`
  - Depends on and exposes the APIs of both `miriam-example-2-java-core` and `miriam-example-2-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`miriam-example-2-java` dependency](#installation) with `miriam-example-2-java-core`
2. Copy `miriam-example-2-java-client-okhttp`'s [`OkHttpClient`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`MiriamExample2ClientImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientImpl.kt) or [`MiriamExample2ClientAsyncImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientAsyncImpl.kt), similarly to [`MiriamExample2OkHttpClient`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClient.kt) or [`MiriamExample2OkHttpClientAsync`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`miriam-example-2-java` dependency](#installation) with `miriam-example-2-java-core`
2. Write a class that implements the [`HttpClient`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/core/http/HttpClient.kt) interface
3. Construct [`MiriamExample2ClientImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientImpl.kt) or [`MiriamExample2ClientAsyncImpl`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/client/MiriamExample2ClientAsyncImpl.kt), similarly to [`MiriamExample2OkHttpClient`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClient.kt) or [`MiriamExample2OkHttpClientAsync`](miriam-example-2-java-client-okhttp/src/main/kotlin/com/configure_me_miriam_example_2/api/client/okhttp/MiriamExample2OkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.configure_me_miriam_example_2.api.core.JsonValue;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;

PetListParams params = PetListParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/core/Values.kt) object to its setter:

```java
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;

PetListParams params = PetListParams.builder().build();
```

The most straightforward way to create a [`JsonValue`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/core/Values.kt) is using its `from(...)` method:

```java
import com.configure_me_miriam_example_2.api.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/core/Values.kt):

```java
import com.configure_me_miriam_example_2.api.core.JsonMissing;
import com.configure_me_miriam_example_2.api.models.pets.NewPet;
import com.configure_me_miriam_example_2.api.models.pets.PetCreateParams;
import com.configure_me_miriam_example_2.api.models.pets.PetListParams;

PetListParams params = PetCreateParams.builder()
    .newPet(NewPet.builder()
        .name("name")
        .build())
    .name(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.configure_me_miriam_example_2.api.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.pets().create(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.configure_me_miriam_example_2.api.core.JsonField;
import java.util.Optional;

JsonField<Object> field = client.pets().create(params)._field();

if (field.isMissing()) {
  // The property is absent from the JSON response
} else if (field.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = field.asString();

  // Try to deserialize into a custom type
  MyClass myObject = field.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`MiriamExample2InvalidDataException`](miriam-example-2-java-core/src/main/kotlin/com/configure_me_miriam_example_2/api/errors/MiriamExample2InvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.configure_me_miriam_example_2.api.models.pets.Pet;

Pet pet = client.pets().create(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.configure_me_miriam_example_2.api.models.pets.Pet;

List<Pet> pets = client.pets().list(RequestOptions.builder().responseValidation(true).build());
```

Or configure the default for all method calls at the client level:

```java
import com.configure_me_miriam_example_2.api.client.MiriamExample2Client;
import com.configure_me_miriam_example_2.api.client.okhttp.MiriamExample2OkHttpClient;

MiriamExample2Client client = MiriamExample2OkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/miriambudayr/miriam-example-2/issues) with questions, bugs, or suggestions.
