package yegor.cheprasov.formulaone.features.settings.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.features.settings.presentation.screen.SettingsScreenDestination

fun NavGraphBuilder.settingsScreenNavigationGraphBuilder(
    navController: NavController,
    tabNavController: NavController
) {
    composable<BottomBarScreen.Settings> {
        SettingsScreenDestination(
            navController = navController
        )
    }
}