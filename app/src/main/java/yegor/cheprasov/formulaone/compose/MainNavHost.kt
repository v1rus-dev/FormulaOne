package yegor.cheprasov.formulaone.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import yegor.cheprasov.formulaone.core.design.transitions.appPredictivePopTransitionSpec
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.debug.presentation.navigation.debugScreenNavigationGraphRoutes
import yegor.cheprasov.formulaone.main.MainDestination

@Composable
fun MainNavHost(
    navController: NavBackStack<Screen>,
    modifier: Modifier = Modifier,
) {
    NavDisplay(
        backStack = navController,
        modifier = modifier.fillMaxSize(),
        onBack = { navController.removeLastOrNull() },
        predictivePopTransitionSpec = appPredictivePopTransitionSpec(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            debugScreenNavigationGraphRoutes(navController = navController)
            entry<Screen.RootRoute> {
                MainDestination(navController = navController)
            }
        }
    )
}

