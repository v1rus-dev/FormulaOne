package yegor.cheprasov.formulaone.features.debug.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.DebugRoute
import yegor.cheprasov.formulaone.features.debug.presentation.screen.DebugScreenDestination

fun NavGraphBuilder.debugScreenNavigationGraphRoutes(navController: NavController) {
    composable<DebugRoute> {
        DebugScreenDestination(navController = navController)
    }
}