plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.drivers_list.presentation"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.features.driversList.data)
}