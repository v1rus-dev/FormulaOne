package yegor.cheprasov.formulaone.features.team_list.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import yegor.cheprasov.formulaone.features.team_list.presentation.screen.composable.TeamListScreen

@Composable
fun TeamListScreenDestination(
    navController: NavController
) {
    val viewModel: TeamListViewModel = koinViewModel()
    TeamListScreen()
}