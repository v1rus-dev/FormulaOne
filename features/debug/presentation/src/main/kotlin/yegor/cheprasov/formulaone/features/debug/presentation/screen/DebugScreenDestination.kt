package yegor.cheprasov.formulaone.features.debug.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.debug.presentation.screen.composable.DebugScreen

@Composable
internal fun DebugScreenDestination(navController: NavBackStack<Screen>) {
    val viewModel: DebugViewModel = koinViewModel()
    DebugScreen()
}