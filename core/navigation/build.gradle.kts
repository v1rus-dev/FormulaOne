plugins {
    alias(libs.plugins.formulaone.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.navigation"
}

dependencies {
    implementation(libs.androidx.navigation3.ui)
}