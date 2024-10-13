import effectivemobile.aleksey.fakehh.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class Retrofit2ConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                add("implementation", libs.findLibrary("retrofit2.kotlinx.serialization.converter").get())
                add("implementation", libs.findLibrary("kotlinx.serialization.json").get())
                add("implementation", libs.findLibrary("retrofit2").get())
                add("implementation", libs.findLibrary("logging.interceptor").get())
            }
        }
    }
}