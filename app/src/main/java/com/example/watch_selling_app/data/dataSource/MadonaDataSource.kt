package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object MadonaDataSource {

    fun getMadonaPictures(): List<ProductData> {
        return listOf(
            ProductData(
                id = 3,
                imageResId =  R.drawable.madona_and_child,
                isFavorite = false,
                watchDesc = R.string.about_madona_child,
                rating = 4.9f,
                modelNameResId = R.string.madona_child_tite
            )
        )
    }
}