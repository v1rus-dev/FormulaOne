package yegor.cheprasov.formulaone.features.home.presentation.navigation

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.home.presentation.screen.HomeScreenDestination

fun EntryProviderScope<BottomBarScreen>.homeScreenEntryPoint(
    navController: NavBackStack<Screen>,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    entry<BottomBarScreen.Home> { entry: BottomBarScreen.Home ->
        HomeScreenDestination(navController = navController, viewModelStoreOwner = viewModelStoreOwner)
    }
}