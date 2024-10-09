plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.daggerHiltAndroid)
}

android {
    namespace = "effectivemobile.aleksey.data.database"
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
    implementation(project(":domain"))

    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}