
plugins {
    kotlin("multiplatform") version "1.4.21"
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useFirefox()
                }
            }
        }
    }
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(project(":collision"))
            }
        }
        val kotestVersion: String by project
        val apacheCommonsMathVersion: String by project
        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-assertions-core:$kotestVersion")
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val jvmTest by getting {
            val jupiterVersion = "5.7.0"
            dependencies {
                implementation("net.mikera:vectorz:0.65.0")
                implementation(kotlin("test-junit5"))
                implementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
            }
        }
    }
}

tasks {
    withType(Test::class).named("jvmTest") {
        useJUnitPlatform()
    }
}