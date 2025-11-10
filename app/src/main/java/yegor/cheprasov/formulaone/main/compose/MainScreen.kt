package yegor.cheprasov.formulaone.main.compose

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
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
import yegor.cheprasov.formulaone.core.navigation.bottomBarItems
import yegor.cheprasov.formulaone.features.home.presentation.navigation.homeScreenNavigationGraphBuilder
import yegor.cheprasov.formulaone.features.settings.presentation.navigation.settingsScreenNavigationGraphBuilder

@Composable
internal fun MainScreen(
    navController: NavController,
    tabNavController: NavHostController,
    modifier: Modifier = Modifier
) {

    val currentDestination = tabNavController.currentBackStackEntryAsState().value?.destination

    val currentBottomBarScreen = when {
        currentDestination?.hasRoute<BottomBarScreen.Home>() == true -> BottomBarScreen.Home
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
        MainTabNavHost(navController, tabNavController)
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