import org.jetbrains.compose.*

plugins {
    kotlin("js") version "1.9.21"
    id("org.jetbrains.compose") version "1.5.11"
    id("app.cash.licensee") version "1.8.0"
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}

dependencies {
    implementation(compose.html.core)
    implementation(npm("chart.js", "3.9.1"))

    testImplementation(kotlin("test"))
}

licensee {
    allow("Apache-2.0")
}
