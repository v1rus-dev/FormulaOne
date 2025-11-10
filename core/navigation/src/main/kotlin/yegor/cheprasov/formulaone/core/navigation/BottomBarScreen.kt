package yegor.cheprasov.formulaone.core.navigation

import kotlinx.serialization.Serializable

val bottomBarItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Settings
)

@Serializable
sealed class BottomBarScreen(
    val route: String,
    val label: String,
) {

    @Serializable
    data object Home : BottomBarScreen("Home", "Home")

    @Serializable
    data object Settings : BottomBarScreen("Settings", "Settings")
}