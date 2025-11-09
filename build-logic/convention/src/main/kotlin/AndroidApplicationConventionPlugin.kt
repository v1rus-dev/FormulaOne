import ext.androidApplication
import ext.androidTestImplementation
import ext.dependencies
import ext.implementation
import ext.libs
import ext.testImplementation
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.android.application")
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.plugin.serialization")

            androidApplication {
                compileSdk = 36

                defaultConfig {
                    minSdk = 28
                    targetSdk = 36
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }

            dependencies {
                implementation(libs.findLibrary("androidx-core-ktx").get())
                implementation(libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
                implementation(libs.findLibrary("jetbrains-serialization-json").get())

                testImplementation(libs.findLibrary("junit").get())
                androidTestImplementation(libs.findLibrary("androidx-junit").get())
                androidTestImplementation(libs.findLibrary("androidx-espresso-core").get())
            }

            tasks.withType<KotlinJvmCompile>().configureEach {
                compilerOptions {
                    jvmTarget = JvmTarget.JVM_17
                }
            }
        }
    }
}