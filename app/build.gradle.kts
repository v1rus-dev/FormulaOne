plugins {
    alias(libs.plugins.formulaone.android.application)
    alias(libs.plugins.formulaone.android.compose)
}

android {
    namespace = "yegor.cheprasov.formulaone"

    defaultConfig {
        applicationId = "yegor.cheprasov.formulaone"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    /**
     * Modules
     */

    implementation(projects.core.api)
    implementation(projects.core.database)
    implementation(projects.core.design)
    implementation(projects.core.navigation)

    implementation(projects.features.root.data)
    implementation(projects.features.root.presentation)

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