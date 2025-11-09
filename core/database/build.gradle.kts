plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.database"
    compileSdk {
        version = release(36)
    }
}