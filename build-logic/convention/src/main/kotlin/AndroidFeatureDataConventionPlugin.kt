import ext.dependencies
import ext.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidFeatureDataConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "formulaone.android.library")
            apply(plugin = "formulaone.koin")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                implementation(project((":core:domain_models")))
                implementation(project((":core:mappers")))
            }
        }
    }
}