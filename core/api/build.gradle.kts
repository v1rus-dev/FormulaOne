plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.api"
    compileSdk {
        version = release(36)
    }
}