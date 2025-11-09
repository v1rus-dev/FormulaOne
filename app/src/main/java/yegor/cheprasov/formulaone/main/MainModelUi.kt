package yegor.cheprasov.formulaone.main

import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.EvaIcons
import compose.icons.evaicons.Fill
import compose.icons.evaicons.fill.Home
import compose.icons.evaicons.fill.Settings
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen


fun BottomBarScreen.getIcon(): ImageVector = when (this) {
    BottomBarScreen.Home -> EvaIcons.Fill.Home
    BottomBarScreen.Settings -> EvaIcons.Fill.Settings
}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Settings::class.simpleName -> BottomBarScreen.Settings
            else -> BottomBarScreen.Home
        }
    }
)