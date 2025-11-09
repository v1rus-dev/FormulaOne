package yegor.cheprasov.formulaone.main.compose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.formulaone.core.navigation.BottomBarScreen
import yegor.cheprasov.formulaone.core.navigation.bottomBarItems
import yegor.cheprasov.formulaone.main.getIcon
import yegor.cheprasov.formulaone.ui.theme.FormulaOneTheme

@Composable
internal fun MainBottomAppBar(
    modifier: Modifier = Modifier,
    selectedTab: BottomBarScreen,
    onClick: (BottomBarScreen) -> Unit
) {
    NavigationBar(modifier = modifier) {
        bottomBarItems.forEach {
            MainBottomAppBarNavigationItem(tab = it, selectedTab = selectedTab, onClick = onClick)
        }
    }
}

@Composable
private fun RowScope.MainBottomAppBarNavigationItem(
    tab: BottomBarScreen,
    selectedTab: BottomBarScreen,
    modifier: Modifier = Modifier,
    onClick: (BottomBarScreen) -> Unit
) {
    NavigationBarItem(
        modifier = modifier, selected = tab == selectedTab,
        label = {
            Text(text = tab.label)
        },
        icon = {
            Icon(imageVector = tab.getIcon(), contentDescription = null)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Blue,
            unselectedIconColor = Color.Blue.copy(alpha = 0.2f),
        ),
        onClick = {
            onClick.invoke(tab)
        }
    )
}

@Preview
@Composable
private fun MainBottomAppBarPreview() {
    var selectedTab: BottomBarScreen by remember { mutableStateOf(BottomBarScreen.Home) }
    FormulaOneTheme {
        MainBottomAppBar(selectedTab = selectedTab) {
            selectedTab = it
        }
    }
}