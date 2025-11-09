import ext.dependencies
import ext.implementation
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                implementation(platform(libs.findLibrary("koin-bom").get()))
                implementation(libs.findLibrary("koin-core-coroutines").get())
                implementation(libs.findLibrary("koin-android").get())
            }
        }
    }
}