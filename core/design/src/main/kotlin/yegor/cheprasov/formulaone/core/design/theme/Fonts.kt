package yegor.cheprasov.formulaone.core.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import yegor.cheprasov.formulaone.core.design.R

// ---------- Шрифты ----------
val FormulaOneRegular = FontFamily(Font(R.font.formula1_regular_1))
val FormulaOneBold = FontFamily(Font(R.font.formula1_bold_4))
val FormulaOneWide = FontFamily(Font(R.font.formula1_wide))

// ---------- Typography ----------
@Immutable
data class FormulaOneTypography(
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,

    // 🔸 wide-стили отдельно
    val wideTitle: TextStyle,
    val wideBody: TextStyle
)

// ---------- CompositionLocal ----------
val LocalFormulaOneTypography = staticCompositionLocalOf<FormulaOneTypography> {
    error("No FormulaOneTypography provided")
}

// ---------- Значения ----------
val FormulaOneTypographySet = FormulaOneTypography(
    displayLarge = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),
    displayMedium = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FormulaOneBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FormulaOneRegular,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),

    // 🔸 Wide-специфичные
    wideTitle = TextStyle(
        fontFamily = FormulaOneWide,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 2.sp
    ),
    wideBody = TextStyle(
        fontFamily = FormulaOneWide,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = 1.5.sp
    )
)