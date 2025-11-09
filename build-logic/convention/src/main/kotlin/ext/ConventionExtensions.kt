package ext

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.android(action: CommonExtension<*, *, *, *, *, *>.() -> Unit) {
    extensions.findByName("android")
        ?.let { extension ->
            @Suppress("UNCHECKED_CAST")
            action.invoke(extension as CommonExtension<*, *, *, *, *, *>)
        }
}

fun Project.androidApplication(action: ApplicationExtension.() -> Unit) {
    extensions.configure(ApplicationExtension::class.java, action)
}

fun Project.androidLibrary(action: LibraryExtension.() -> Unit) {
    extensions.configure(LibraryExtension::class.java, action)
}

fun Project.dependencies(action: DependencyHandler.() -> Unit): DependencyHandler {
    val handler = this.dependencies
    return handler.apply(action)
}

fun DependencyHandler.implementation(dep: Any) = add("implementation", dep)
fun DependencyHandler.api(dep: Any) = add("api", dep)
fun DependencyHandler.kapt(dep: Any) = add("kapt", dep)
fun DependencyHandler.ksp(dep: Any) = add("ksp", dep)
fun DependencyHandler.testImplementation(dep: Any) = add("testImplementation", dep)
fun DependencyHandler.androidTestImplementation(dep: Any) = add("androidTestImplementation", dep)
fun DependencyHandler.debugImplementation(dep: Any) = add("debugImplementation", dep)

fun Project.kotlin(action: Any.() -> Unit) {
    val ext = extensions.findByName("kotlin")
        ?: error("Kotlin extension not found in project $name")
    action(ext)
}

fun Project.kotlinAndroid(action: KotlinAndroidProjectExtension.() -> Unit) {
    extensions.configure(KotlinAndroidProjectExtension::class.java, action)
}

fun Project.kotlinJvm(action: KotlinJvmProjectExtension.() -> Unit) {
    extensions.configure(KotlinJvmProjectExtension::class.java, action)
}

fun Project.kotlinMultiplatform(action: KotlinMultiplatformExtension.() -> Unit) {
    extensions.configure(KotlinMultiplatformExtension::class.java, action)
}