plugins {
    alias(libs.plugins.formulaone.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.navigation"
}

dependencies {
    implementation(projects.core.domainModels)
}