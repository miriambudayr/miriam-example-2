plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Swagger Petstore")
                description.set("A sample API that uses a petstore as an example to demonstrate features in the\nOpenAPI 3.0 specification")
                url.set("https://swagger.ioooooooo")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Miriam Example 2")
                        email.set("apiteam@swagger.io")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/miriam-example-2-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/miriam-example-2-java.git")
                    url.set("https://github.com/stainless-sdks/miriam-example-2-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
