package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object CasualProductDataSource {
    fun getCasualWatches(): List<ProductData> {
        return listOf(
            ProductData(
                id = 2,
                imageResId =  R.drawable.lady_with_ermine,
                isFavorite = false,
                watchDesc = R.string.about_ermine,
                rating = 4.9f,
                modelNameResId = R.string.lady_ermine_tite
            )
        )
    }
}