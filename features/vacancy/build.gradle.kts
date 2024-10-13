plugins {
    alias(libs.plugins.fakehh.android.library)
    alias(libs.plugins.fakehh.android.feature)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.features.vacancy"
}

dependencies {
    implementation(project(":common:utilities"))
    implementation(project(":common:ui"))
    implementation(project(":domain"))
}