plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    val reactVersion = "^16.14.0"

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.0")
    implementation(npm("react", reactVersion))
    implementation(npm("react-is", "16.8.0"))
    implementation(npm("react-dom", reactVersion))

    //Kotlin Styled (chapter 3)
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.110-kotlin-1.4.0")
    implementation(npm("styled-components", "~5.1.1"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))
    implementation(npm("linear-equation-system", "1.1.1"))

    implementation(project(":core"))
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
}