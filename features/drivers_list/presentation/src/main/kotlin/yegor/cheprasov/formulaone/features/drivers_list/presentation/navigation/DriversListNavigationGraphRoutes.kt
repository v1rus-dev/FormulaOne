package yegor.cheprasov.formulaone.features.drivers_list.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.features.drivers_list.presentation.screen.DriversListScreenDestination

fun NavGraphBuilder.driversListScreenNavigationGraphRoute(
    navController: NavController,
    tabNavController: NavController
) {
    composable<BottomBarScreen.Drivers> {
        DriversListScreenDestination(navController = navController)
    }
}