plugins {
    alias(libs.plugins.fakehh.android.application)
}

android {
    namespace = "effectivemobile.aleksey.fakehh"

    defaultConfig {
        applicationId = "effectivemobile.aleksey.fakehh"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
