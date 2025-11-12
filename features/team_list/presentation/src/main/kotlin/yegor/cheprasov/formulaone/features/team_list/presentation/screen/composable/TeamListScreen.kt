package yegor.cheprasov.formulaone.features.team_list.presentation.screen.composable

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import yegor.cheprasov.formulaone.core.domein_models.enums.Command

@Composable
fun TeamListScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets(0, 0, 0, 0)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            items(items = Command.entries, key = { item -> item.commandName }) { item ->
                CommandRowItem(item)
            }
        }
    }
}