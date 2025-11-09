package yegor.cheprasov.formulaone.features.debug.presentation.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.debug.presentation.screen.DebugScreenDestination

fun EntryProviderScope<Screen>.debugScreenNavigationGraphRoutes(navController: NavBackStack<Screen>) {
    entry<Screen.DebugRoute> {
        DebugScreenDestination(navController = navController)
    }
}