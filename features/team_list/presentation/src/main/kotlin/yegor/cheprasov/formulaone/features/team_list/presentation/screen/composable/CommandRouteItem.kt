package yegor.cheprasov.formulaone.features.team_list.presentation.screen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.formulaone.core.domein_models.enums.Command

@Composable
internal fun CommandRowItem(
    item: Command,
    modifier: Modifier = Modifier,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(item.commandName)
    }
}

@Preview
@Composable
private fun TestItemPreview() {
    CommandRowItem(item = Command.AstonMartin)
}