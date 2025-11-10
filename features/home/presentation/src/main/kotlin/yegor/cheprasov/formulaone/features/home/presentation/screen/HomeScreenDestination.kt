package yegor.cheprasov.formulaone.features.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.features.home.presentation.screen.composable.HomeScreen

@Composable
internal fun HomeScreenDestination(
    navController: NavController
) {
    val viewModel: HomeViewModel = koinViewModel()
    HomeScreen()
}