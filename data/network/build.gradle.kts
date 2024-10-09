plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.devtoolsKsp)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.data.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
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
    implementation(project(":common:utilities"))
    implementation(project(":domain"))

    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2)
    implementation(libs.logging.interceptor)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}