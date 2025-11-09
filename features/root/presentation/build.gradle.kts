plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.fetures.root.data"
    compileSdk {
        version = release(36)
    }
}