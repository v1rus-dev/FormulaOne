package yegor.cheprasov.formulaone.features.debug.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.features.debug.presentation.screen.composable.DebugScreen

@Composable
internal fun DebugScreenDestination(navController: NavController) {
    val viewModel: DebugViewModel = koinViewModel()
    DebugScreen()
}