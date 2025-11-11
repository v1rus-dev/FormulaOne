plugins {
    alias(libs.plugins.formulaone.feature.presentation)
}

android {
    namespace = "yegor.cheprasov.formulaone.features.team_list.presentation"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.features.teamList.data)
}