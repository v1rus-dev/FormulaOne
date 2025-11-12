package yegor.cheprasov.formulaone.core.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun FormulaOneTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalFormulaOneTypography provides FormulaOneTypographySet,
        content = content
    )
}

object FormulaOneTheme {
    val fonts: FormulaOneTypography
        @Composable
        get() = LocalFormulaOneTypography.current
}