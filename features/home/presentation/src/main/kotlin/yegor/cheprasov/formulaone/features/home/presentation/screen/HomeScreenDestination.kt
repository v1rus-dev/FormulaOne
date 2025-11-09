package yegor.cheprasov.formulaone.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation3.runtime.NavBackStack
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.features.home.presentation.screen.composable.HomeScreen

@Composable
internal fun HomeScreenDestination(
    navController: NavBackStack<Screen>,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val viewModel: HomeViewModel = koinViewModel(viewModelStoreOwner = viewModelStoreOwner)
    HomeScreen()
}