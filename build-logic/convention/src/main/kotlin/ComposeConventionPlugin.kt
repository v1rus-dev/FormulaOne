import ext.android
import ext.implementation
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.findPlugin("kotlin-android").get().get().pluginId)
            plugins.apply(libs.findPlugin("kotlin-compose").get().get().pluginId)

            android {
                buildFeatures {
                    compose = true
                }
            }

            dependencies {
                implementation(project(":core:navigation"))

                implementation(platform(libs.findLibrary("androidx-compose-bom").get()))
                implementation(libs.findLibrary("androidx-compose-ui").get())
                implementation(libs.findLibrary("androidx-compose-ui-graphics").get())
                implementation(libs.findLibrary("androidx-compose-foundation").get())
                implementation(libs.findLibrary("androidx-compose-adaptive").get())
                implementation(libs.findLibrary("androidx-compose-ui-tooling").get())
                implementation(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
                implementation(libs.findLibrary("androidx-compose-material3").get())
                implementation(libs.findLibrary("androidx-navigation-compose").get())

                implementation(libs.findLibrary("composeIcons-evaIcons").get())
                implementation(libs.findLibrary("coil-compose").get())
                implementation(libs.findLibrary("coil-network-okhttp").get())
            }
        }
    }
}