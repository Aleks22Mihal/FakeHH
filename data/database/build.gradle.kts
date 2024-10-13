plugins {
    alias(libs.plugins.fakehh.android.library)
    alias(libs.plugins.fakehh.hilt)
    alias(libs.plugins.fakehh.room)
}

android {
    namespace = "effectivemobile.aleksey.data.database"
}

dependencies {
    implementation(project(":domain"))
}