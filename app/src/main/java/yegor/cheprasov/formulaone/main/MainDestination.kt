package yegor.cheprasov.formulaone.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import yegor.cheprasov.formulaone.main.compose.MainScreen
import yegor.cheprasov.formulaone.main.compose.enableOnDestinationChangedFadeFix

@Composable
fun MainDestination(navController: NavController) {
    val tabNavController = rememberNavController()

    LaunchedEffect(tabNavController) {
        tabNavController.enableOnDestinationChangedFadeFix()
    }

    MainScreen(navController = navController, tabNavController = tabNavController)
}