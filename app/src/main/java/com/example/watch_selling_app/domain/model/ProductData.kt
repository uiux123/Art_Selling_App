package com.example.watch_selling_app.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProductData(
    val id: Int,
    @StringRes val modelNameResId: Int,
    @DrawableRes val imageResId: Int,
    val isFavorite: Boolean = false,
    @StringRes val watchDesc : Int,
    val rating: Float,

)
