package yegor.cheprasov.formulaone.main.compose

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.features.drivers_list.presentation.navigation.driversListScreenNavigationGraphRoute
import yegor.cheprasov.formulaone.features.home.presentation.navigation.homeScreenNavigationGraphBuilder
import yegor.cheprasov.formulaone.features.settings.presentation.navigation.settingsScreenNavigationGraphBuilder
import yegor.cheprasov.formulaone.features.team_list.presentation.navigation.teamListScreenNavigationGraphRoute

@Composable
internal fun MainScreen(
    navController: NavController,
    tabNavController: NavHostController,
    modifier: Modifier = Modifier
) {

    val currentDestination = tabNavController.currentBackStackEntryAsState().value?.destination

    val currentBottomBarScreen = when {
        currentDestination?.hasRoute<BottomBarScreen.Home>() == true -> BottomBarScreen.Home
        currentDestination?.hasRoute<BottomBarScreen.Drivers>() == true -> BottomBarScreen.Drivers
        currentDestination?.hasRoute<BottomBarScreen.Teams>() == true -> BottomBarScreen.Teams
        currentDestination?.hasRoute<BottomBarScreen.Settings>() == true -> BottomBarScreen.Settings
        else -> BottomBarScreen.Home
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            MainBottomAppBar(selectedTab = currentBottomBarScreen) { selected ->
                if (selected != currentBottomBarScreen) {
                    tabNavController.navigate(selected) {
                        popUpTo(tabNavController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        },
        contentWindowInsets = WindowInsets.navigationBars
    ) {
        MainTabNavHost(navController, tabNavController, modifier = Modifier.padding(it))
    }
}

@Composable
private fun MainTabNavHost(
    navController: NavController,
    tabNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = tabNavController,
        modifier = modifier,
        startDestination = BottomBarScreen.Home,
        sizeTransform = { null },
        contentAlignment = Alignment.Center
    ) {
        homeScreenNavigationGraphBuilder(navController, tabNavController)
        settingsScreenNavigationGraphBuilder(navController, tabNavController)
        driversListScreenNavigationGraphRoute(navController, tabNavController)
        teamListScreenNavigationGraphRoute(navController, navController)
    }
}

fun NavController.enableOnDestinationChangedFadeFix() {
    var lastDestinationId: Int? = null
    addOnDestinationChangedListener { _, destination, _ ->
        if (lastDestinationId != destination.id) {
            lastDestinationId = destination.id
        }
    }
}