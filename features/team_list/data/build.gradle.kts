plugins {
    alias(libs.plugins.formulaone.feature.data)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.team_list.data"
}

dependencies {
    implementation(projects.core.api)
    implementation(projects.core.data)
}