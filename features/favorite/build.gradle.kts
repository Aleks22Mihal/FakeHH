plugins {
    alias(libs.plugins.fakehh.android.library)
    alias(libs.plugins.fakehh.android.feature)
}

android {
    namespace = "effectivemobile.aleksey.fakehh.features.favorite"
}

dependencies {
    implementation(project(":common:utilities"))
    implementation(project(":common:ui"))
    implementation(project(":domain"))
    implementation(project(":features:vacancy"))
}