package yegor.cheprasov.formulaone.main.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.core.navigation.Screen
import yegor.cheprasov.formulaone.core.navigation.bottomBarItems
import yegor.cheprasov.formulaone.features.home.presentation.navigation.homeScreenEntryPoint
import yegor.cheprasov.formulaone.features.settings.presentation.navigation.settingsScreenEntryPoint
import yegor.cheprasov.formulaone.main.BottomBarScreenSaver

@Composable
internal fun MainScreen(
    navController: NavBackStack<Screen>,
    modifier: Modifier = Modifier
) {
    val viewModelStoreOwners = remember {
        mutableMapOf<BottomBarScreen, ViewModelStoreOwner>().apply {
            bottomBarItems.forEach { screen ->
                put(screen, object : ViewModelStoreOwner {
                    val store = ViewModelStore()
                    override val viewModelStore: ViewModelStore = store
                })
            }
        }
    }

    val backStack = rememberNavBackStack(BottomBarScreen.Home)

    var currentBottomBarScreen: BottomBarScreen by rememberSaveable(stateSaver = BottomBarScreenSaver) {
        mutableStateOf(BottomBarScreen.Home)
    }

    val provider = entryProvider {
        homeScreenEntryPoint(navController = navController, viewModelStoreOwner = viewModelStoreOwners[BottomBarScreen.Home]!!)
        settingsScreenEntryPoint(navController = navController, viewModelStoreOwner = viewModelStoreOwners[BottomBarScreen.Settings]!!)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            MainBottomAppBar(selectedTab = currentBottomBarScreen) {
                if (backStack.lastOrNull() != it) {
                    if (backStack.lastOrNull() in bottomBarItems) {
                        backStack.removeAt(backStack.lastIndex)
                    }
                    backStack.add(it)
                    currentBottomBarScreen = it
                }
            }
        },
        contentWindowInsets = WindowInsets.navigationBars
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(it))
        NavDisplay(
            backStack = backStack as NavBackStack<BottomBarScreen>,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = provider)
    }
}