plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.features.favorite"
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
    implementation(project(":common:ui"))
    implementation(project(":domain"))
    implementation(project(":features:vacancy"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)


    debugImplementation(libs.androidx.ui.tooling)

}