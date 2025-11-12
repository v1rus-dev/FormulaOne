package yegor.cheprasov.formulaone.features.team_list.presentation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.formulaone.core.design.extensions.CarBitmapsCache
import yegor.cheprasov.formulaone.core.design.extensions.getColor
import yegor.cheprasov.formulaone.core.design.theme.FormulaOneTheme
import yegor.cheprasov.formulaone.core.domein_models.enums.Command

@Composable
internal fun CommandRowItem(
    item: Command,
    modifier: Modifier = Modifier,
) {
    val bitmap = remember { CarBitmapsCache.get(item) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(item.getColor())
            .padding(horizontal = 16.dp)
    ) {
        Box {
            Text(
                item.commandName,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.TopStart),
                style = FormulaOneTheme.fonts.headlineLarge.copy(color = Color.White)
            )
            Image(
                painter = BitmapPainter(bitmap.asImageBitmap()),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(top = 35.dp)
                    .width(250.dp),
            )
        }
    }
}

@Preview
@Composable
private fun CommandRowPreview() {
    FormulaOneTheme {
        CommandRowItem(item = Command.AstonMartin)
    }
}

@Preview
@Composable
private fun CommandsPreview() {
    val context = LocalContext.current
    CarBitmapsCache.preload(context = context)
    FormulaOneTheme {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = Command.entries) { item ->
                CommandRowItem(item = item)
            }
        }
    }
}