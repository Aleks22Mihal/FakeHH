plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "effectivemobile.aleksey.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {
    implementation (project(":common:utilities"))
    implementation(libs.hilt.android)
}