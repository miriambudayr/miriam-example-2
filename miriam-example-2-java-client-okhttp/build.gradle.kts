plugins {
    id("miriam-example-2.kotlin")
    id("miriam-example-2.publish")
}

dependencies {
    api(project(":miriam-example-2-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.25.3")
}
