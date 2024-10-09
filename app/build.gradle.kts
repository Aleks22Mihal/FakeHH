plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtoolsKsp)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "effectivemobile.aleksey.fakehh"
    compileSdk = 34

    defaultConfig {
        applicationId = "effectivemobile.aleksey.fakehh"
        minSdk = 26
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(project(":data:database"))
    implementation(project(":data:network"))

    implementation(project(":common:utilities"))
    implementation(project(":common:ui"))

    implementation(project(":features:main"))
    implementation(project(":features:favorite"))
    implementation(project(":features:vacancy"))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)

    implementation(libs.kotlinx.serialization.json)
}