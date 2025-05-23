plugins {
    id("miriam-example-2.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":miriam-example-2-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.configure_me_miriam_example_2.api.example.Main"
}
