package yegor.cheprasov.formulaone.features.settings.presentation.navigation

import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.settings.presentation.screen.SettingsScreenDestination

fun EntryProviderScope<BottomBarScreen>.settingsScreenEntryPoint(
    navController: NavBackStack<Screen>,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    entry<BottomBarScreen.Settings> {
        SettingsScreenDestination(navController = navController, viewModelStoreOwner = viewModelStoreOwner)
    }
}