import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "yegor.cheprasov.formulaone.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradleApiPlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.formulaone.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.formulaone.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = libs.plugins.formulaone.android.compose.get().pluginId
            implementationClass = "ComposeConventionPlugin"
        }
        register("androidFeatureData") {
            id = libs.plugins.formulaone.feature.data.get().pluginId
            implementationClass = "AndroidFeatureDataConventionPlugin"
        }
        register("androidFeaturePresentation") {
            id = libs.plugins.formulaone.feature.presentation.get().pluginId
            implementationClass = "AndroidFeaturePresentationConventionPlugin"
        }
        register("androidKoin") {
            id = libs.plugins.formulaone.koin.asProvider().get().pluginId
            implementationClass = "KoinConventionPlugin"
        }
        register("androidKoinCompose") {
            id = libs.plugins.formulaone.koin.compose.get().pluginId
            implementationClass = "KoinComposeConventionPlugin"
        }
        register("retrofit") {
            id = libs.plugins.formulaone.retrofit.get().pluginId
            implementationClass = "RetrofitConventionPlugin"
        }
    }
}