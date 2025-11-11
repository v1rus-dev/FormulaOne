plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.koin)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.data"
}

dependencies {
    implementation(projects.core.api)
    implementation(projects.core.mappers)
    implementation(projects.core.domainModels)
}