package yegor.cheprasov.formulaone.features.settings.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.core.navigation.DebugRoute
import yegor.cheprasov.formulaone.features.settings.presentation.screen.composable.SettingsScreen

@Composable
internal fun SettingsScreenDestination(
    navController: NavController
) {
    val viewModel: SettingsViewModel = koinViewModel()
    SettingsScreen {
        navController.navigate(DebugRoute)
    }
}