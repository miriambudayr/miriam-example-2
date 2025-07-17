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
    // Use `./gradlew :miriam-example-2-java-example:run` to run `Main`
    // Use `./gradlew :miriam-example-2-java-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "com.configure_me_miriam_example_2.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
