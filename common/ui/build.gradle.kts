plugins {
    alias(libs.plugins.fakehh.android.library)
    alias(libs.plugins.fakehh.compose)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.common.ui"
}

dependencies {
    implementation(project(":domain"))
}