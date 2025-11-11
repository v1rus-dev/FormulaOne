package yegor.cheprasov.formulaone.core.navigation

import kotlinx.serialization.Serializable

val bottomBarItems = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Drivers,
    BottomBarScreen.Teams,
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
    data object Drivers : BottomBarScreen("Drivers", "Drivers")

    @Serializable
    data object Teams : BottomBarScreen("Teams", "Teams")

    @Serializable
    data object Settings : BottomBarScreen("Settings", "Settings")
}