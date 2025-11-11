package yegor.cheprasov.formulaone.features.team_list.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.features.team_list.presentation.screen.TeamListScreenDestination

fun NavGraphBuilder.teamListScreenNavigationGraphRoute(
    navController: NavController,
    tabNavController: NavController
) {
    composable<BottomBarScreen.Teams> {
        TeamListScreenDestination(navController = navController)
    }
}