package yegor.cheprasov.formulaone.features.settings.presentation.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation3.runtime.NavBackStack
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.settings.presentation.screen.composable.SettingsScreen

@Composable
internal fun SettingsScreenDestination(
    navController: NavBackStack<Screen>,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val viewModel: SettingsViewModel = koinViewModel(viewModelStoreOwner = viewModelStoreOwner)
    SettingsScreen {
        navController.add(Screen.DebugRoute)
    }
}