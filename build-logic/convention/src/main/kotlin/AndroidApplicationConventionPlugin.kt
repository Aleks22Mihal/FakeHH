import com.android.build.api.dsl.ApplicationExtension
import effectivemobile.aleksey.fakehh.convention.configureKotlinAndroid
import effectivemobile.aleksey.fakehh.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("fakehh.hilt")
                apply("fakehh.android.application.compose")
            }

            dependencies {

                add("implementation", project(":domain"))
                add("implementation", project(":data:database"))
                add("implementation", project(":data:network"))
                add("implementation", project(":common:utilities"))
                add("implementation", project(":common:ui"))
                add("implementation", project(":features:main"))
                add("implementation", project(":features:favorite"))
                add("implementation", project(":features:vacancy"))

                add("implementation", libs.findLibrary("androidx.core.ktx").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
                add("implementation", libs.findLibrary("androidx.activity.compose").get())

                add("implementation", libs.findLibrary("androidx.navigation.compose").get())
                add("implementation", libs.findLibrary("kotlinx.serialization.json").get())
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
            }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
            }
        }
    }
}
