import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "effectivemobile.aleksey.fakehh.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_19
    }

}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {

        register("androidApplication") {
            id = "fakehh.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "fakehh.android.application.compose"
            implementationClass = "ApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "fakehh.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("hilt") {
            id = "fakehh.hilt"
            implementationClass = "HiltConventionPlugin"
        }

        register("jvmLibrary") {
            id = "fakehh.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("room") {
            id = "fakehh.room"
            implementationClass = "RoomConventionPlugin"
        }

        register("retrofit2") {
            id = "fakehh.retrofit2"
            implementationClass = "Retrofit2ConventionPlugin"
        }

        register("compose") {
            id = "fakehh.compose"
            implementationClass = "ComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "fakehh.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}