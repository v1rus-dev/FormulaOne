plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.settings.presentation"
}

dependencies {
    implementation(projects.features.settings.data)
}