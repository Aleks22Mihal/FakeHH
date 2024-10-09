package effectivemobile.aleksey.fakehh.common.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import effectivemobile.aleksey.fakehh.common.ui.R

// Set of Material typography styles to start with
private val SFFont = FontFamily(
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sd_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal)
)

val Shapes = Shapes(
    extraLarge = RoundedCornerShape(100.dp),
    large = RoundedCornerShape(50.dp),
    medium = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(4.dp),
    extraSmall = RoundedCornerShape(2.dp)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = SFFont,
        fontWeight = FontWeight.Normal,
        fontSize = 7.sp,
        lineHeight = 9.sp,
        letterSpacing = 0.5.sp
    ),
)