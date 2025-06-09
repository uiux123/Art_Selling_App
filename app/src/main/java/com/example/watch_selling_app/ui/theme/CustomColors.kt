package com.example.watch_selling_app.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val luxuryGold: Color,
    val premiumGrey : Color,
    val textColor : Color
) {

}

// Default light theme colors
val LightCustomColors = CustomColors(
    luxuryGold = Color(0xFF2563EB),
    premiumGrey = Color(0xFFE5E5E5),
    textColor = Color(0xFFFFFFFF)

)

// Default dark theme colors
val DarkCustomColors = CustomColors(
    luxuryGold = Color(0xFFFFC107),
    premiumGrey = Color(0xFF2C2C2E),
    textColor = Color(0xFFFFFFFF)
)


// Provide access via CompositionLocal
val LocalCustomColors = staticCompositionLocalOf { LightCustomColors }
