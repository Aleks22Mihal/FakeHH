plugins {
    alias(libs.plugins.fakehh.android.library)
    alias(libs.plugins.fakehh.retrofit2)
    alias(libs.plugins.fakehh.hilt)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.data.network"
}

dependencies {
    implementation(project(":common:utilities"))
    implementation(project(":domain"))
}