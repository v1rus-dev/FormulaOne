plugins {
    alias(libs.plugins.formulaone.android.library)
}

android {
    namespace = "yegor.cheprasov.formulaone.core.mappers"
}

dependencies {
    implementation(projects.core.api)
    implementation(projects.core.domainModels)
}