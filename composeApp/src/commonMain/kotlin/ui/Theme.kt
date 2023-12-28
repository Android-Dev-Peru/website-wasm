package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AndroidColors = lightColors(
    surface = Color(0xFFF4FDF4),
    background = Color(0xFFA6EB99)
)

var DMSans: FontFamily? = null

val AndroidTypography by lazy {
    Typography(
        h1 = TextStyle(
            fontFamily = DMSans,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            ),
        h2 = TextStyle(
            fontFamily = DMSans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            ),
        )
}

@Composable
fun AndroidTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = AndroidColors, typography = AndroidTypography, content = content)
}
