plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.home.presentation"
}

dependencies {
    implementation(projects.features.home.data)
}