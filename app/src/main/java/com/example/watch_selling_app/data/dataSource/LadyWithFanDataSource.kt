package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object LadyWithFanDataSource {
    fun getLadyWithFanPictures(): List<ProductData> {
        return listOf(
            ProductData(
                id = 3,
                imageResId =  R.drawable.lady_with_fan,
                isFavorite = false,
                watchDesc = R.string.about_lady_with_fan,
                rating = 4.4f,
                modelNameResId = R.string.lady_with_tite
            )
        )
    }
}