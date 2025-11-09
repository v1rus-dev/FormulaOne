plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.fetures.root.presentation"
}

dependencies {
    implementation(projects.features.root.data)
}