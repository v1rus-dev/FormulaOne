package yegor.cheprasov.formulaone.features.drivers_list.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.features.drivers_list.presentation.screen.composable.DriversListScreen

@Composable
fun DriversListScreenDestination(
    navController: NavController
) {
    val viewModel: DriversListViewModel = koinViewModel()
    DriversListScreen()
}