package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object TheKissDataSource {

    fun theKissPictures(): List<ProductData> {
        return listOf(
            ProductData(
                id = 5,
                imageResId =  R.drawable.the_kiss,
                isFavorite = false,
                watchDesc = R.string.about_the_kiss,
                rating = 4.2f,
                modelNameResId = R.string.the_kiss_tite
            )
        )
    }
}