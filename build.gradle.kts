import org.jetbrains.compose.*

plugins {
    kotlin("js") version "1.7.20"
    id("org.jetbrains.compose") version "1.3.1"
}

repositories {
    mavenCentral()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}

dependencies {
    implementation(compose.web.core)
    implementation(npm("chart.js", "3.9.1", generateExternals = false))

    testImplementation(kotlin("test"))
}
