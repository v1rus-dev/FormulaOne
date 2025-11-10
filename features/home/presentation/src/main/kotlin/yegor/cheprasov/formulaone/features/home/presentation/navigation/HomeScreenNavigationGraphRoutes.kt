package yegor.cheprasov.formulaone.features.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.features.home.presentation.screen.HomeScreenDestination

fun NavGraphBuilder.homeScreenNavigationGraphBuilder(
    navController: NavController,
    tabNavController: NavController
) {
    composable<BottomBarScreen.Home> {
        HomeScreenDestination(navController = navController)
    }
}