plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.design"
    compileSdk {
        version = release(36)
    }
}

dependencies {
    implementation(libs.jetbrains.serialization.json)
}