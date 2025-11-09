package yegor.cheprasov.formulaone.main

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.main.compose.MainScreen

@Composable
fun MainDestination(navController: NavBackStack<Screen>) {
    MainScreen(navController = navController)
}