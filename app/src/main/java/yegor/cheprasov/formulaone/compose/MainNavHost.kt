package yegor.cheprasov.formulaone.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import yegor.cheprasov.formulaone.core.navigation.RootRoute
import yegor.cheprasov.formulaone.features.debug.presentation.navigation.debugScreenNavigationGraphRoutes
import yegor.cheprasov.formulaone.main.MainDestination

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = RootRoute
    ) {
        composable<RootRoute> { MainDestination(navController = navController) }
        debugScreenNavigationGraphRoutes(navController)
    }
}

