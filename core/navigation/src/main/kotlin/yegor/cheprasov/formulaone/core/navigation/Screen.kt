package yegor.cheprasov.formulaone.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen : NavKey {

    @Serializable
    data object RootRoute : Screen()

    @Serializable
    data object DebugRoute : Screen()
}