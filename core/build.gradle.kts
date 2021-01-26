
plugins {
    kotlin("multiplatform") version "1.4.21"
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useChrome()
                }
            }
        }
    }
    jvm {
        tasks {
            withType(Test::class){
                useJUnitPlatform()
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
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
        val jsMain by getting {
            dependencies {
                implementation(npm("linear-solve", "1.2.1"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("net.mikera:vectorz:0.65.0")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("net.mikera:vectorz:0.65.0")
//                implementation("org.apache.commons:commons-math3:$apacheCommonsMathVersion")
                implementation(kotlin("test-jvm"))
            }
        }
    }
}
