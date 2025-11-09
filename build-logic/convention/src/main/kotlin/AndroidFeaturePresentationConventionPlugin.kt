import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidFeaturePresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "formulaone.android.library")
            apply(plugin = "formulaone.koin")
            apply(plugin = "formulaone.koin.compose")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
        }
    }
}