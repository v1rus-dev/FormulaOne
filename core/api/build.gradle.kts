plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.koin)
    alias(libs.plugins.formulaone.retrofit)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.api"
}