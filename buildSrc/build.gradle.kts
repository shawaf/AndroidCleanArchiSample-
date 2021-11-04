
plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.31" // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "1.5.31"
}
// Required since Gradle 4.10+.
repositories {
    jcenter()
}