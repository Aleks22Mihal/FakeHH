import effectivemobile.aleksey.fakehh.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }
            dependencies{
                add("ksp", libs.findLibrary("hilt.android.compiler").get())
                add("implementation", libs.findLibrary("hilt.android").get())
            }
        }
    }
}