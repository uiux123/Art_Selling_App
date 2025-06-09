package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object PearlGirlDataSource {
    fun getProducts(): List<ProductData> {
        return listOf(
            ProductData(
                imageResId = R.drawable.pear_girl,
                isFavorite = false,
                id = 1,
                watchDesc = R.string.pearl_girl,
                rating = 4.5f,
                modelNameResId = R.string.pearl_girl_tite,
            )

        )
    }


}