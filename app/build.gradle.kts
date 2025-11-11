plugins {
    alias(libs.plugins.formulaone.android.application)
    alias(libs.plugins.formulaone.android.compose)
    alias(libs.plugins.formulaone.koin)
    alias(libs.plugins.formulaone.koin.compose)
}

android {
    namespace = "yegor.cheprasov.formulaone"

    defaultConfig {
        applicationId = "yegor.cheprasov.formulaone"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    /**
     * Modules
     */

    implementation(projects.core.api)
    implementation(projects.core.data)
    implementation(projects.core.database)
    implementation(projects.core.design)
    implementation(projects.core.navigation)

    debugImplementation(projects.features.debug.data)
    debugImplementation(projects.features.debug.presentation)

    implementation(projects.features.home.data)
    implementation(projects.features.home.presentation)

    implementation(projects.features.settings.data)
    implementation(projects.features.settings.presentation)

    implementation(projects.features.driversList.data)
    implementation(projects.features.driversList.presentation)

    implementation(projects.features.teamList.data)
    implementation(projects.features.teamList.presentation)

    /**
     * Test or debug
     */
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
//    debugImplementation(libs.androidx.compose.ui.tooling)
//    debugImplementation(libs.androidx.compose.ui.test.manifest)
}