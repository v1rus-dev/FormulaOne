import ext.dependencies
import ext.implementation
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class RetrofitConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                implementation(libs.findLibrary("retrofit").get())
                implementation(libs.findLibrary("retrofit-converter-scalars").get())
                implementation(libs.findLibrary("retrofit-converter-json").get())
                implementation(libs.findLibrary("okhttp").get())
                implementation(libs.findLibrary("okhttp-logging-interceptor").get())
            }
        }
    }
}