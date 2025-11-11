plugins {
    alias(libs.plugins.formulaone.feature.data)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.drivers_list.data"
}

dependencies {
    implementation(projects.core.api)
    implementation(projects.core.data)
}