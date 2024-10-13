plugins {
    alias(libs.plugins.fakehh.android.library)
}

android {
    namespace = "effectivemobile.aleksey.domain"
}

dependencies {
    implementation (project(":common:utilities"))
    implementation(libs.hilt.android)
}