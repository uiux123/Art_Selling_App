package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.ProductData

object ArtStoretDataSource {

    fun getStoreProducts(): List<ProductData> {
        return listOf(
            ProductData(
                imageResId = R.drawable.munch_edvard_3,
                isFavorite = false,
                id = 6,
                watchDesc = R.string.about_munch_devard,
                rating = 4.2f,
                modelNameResId = R.string.munch_edward_tite
            ),
            ProductData(

                imageResId = R.drawable.vincent_van_gogh_self_portrait_google_art_project,
                isFavorite = false,
                id = 1,
                watchDesc = R.string.about_vincent_van_gogh,
                rating = 4.5f,
                modelNameResId = R.string.self_portarit_tite
            ),
            ProductData(
                imageResId = R.drawable.gust,
                isFavorite = false,
                id = 1,
                watchDesc = R.string.about_gust,
                rating = 4.5f,
                modelNameResId = R.string.gust_tite
            )

        )

    }
}