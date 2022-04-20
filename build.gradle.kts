import org.jetbrains.compose.*

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("org.jetbrains.compose") version "0.0.0-on-rebase-12-apr-2022-dev670"
}

repositories {
    mavenCentral()
    jetbrainsCompose()
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(npm("chart.js", "3.7.1", generateExternals = false))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
