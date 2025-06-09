package com.example.watch_selling_app.presentation.components.brand

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.watch_selling_app.domain.model.BrandData
import com.example.watch_selling_app.presentation.screen.Login_Screen.getSafeString
import com.example.watch_selling_app.ui.theme.Dimens
import com.example.watch_selling_app.ui.theme.LocalCustomColors

@Composable
fun BrandItem(
    brand: BrandData,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .border(width = Dimens.border_width_medium, color = MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(size = Dimens.RadiusMedium))
                .clickable(onClick = onClick)
                .padding(Dimens.SpacingM)
                .size(Dimens.brand_size),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = brand.logoResId),
                contentDescription = getSafeString(brand.logoDescriptionResId.toString()),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,


            )
        }

        Text(
            text = getSafeString(brand.nameResId.toString()),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = Dimens.SpacingXXS),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

