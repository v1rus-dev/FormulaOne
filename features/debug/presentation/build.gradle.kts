plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.debug.presentation"
}

dependencies {
    implementation(projects.features.debug.data)
}