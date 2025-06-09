package com.example.watch_selling_app.data.dataSource

import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.BrandData

object BrandDataSource {

    fun getBrands(): List<BrandData> = listOf(
        BrandData(
            nameResId = R.string.brand_portrait,
            logoDescriptionResId = R.string.brand_portrait_description,
            logoResId = R.drawable.mona_lisa,
            id = 1,

        ),
        BrandData(
            nameResId = R.string.brand_Landscape,
            logoDescriptionResId = R.string.brand_landscape_description,
            logoResId = R.drawable.landscape,
            id = 2
        ),
        BrandData(
            nameResId = R.string.brand_Still_Life,
            logoDescriptionResId = R.string.brand_still_life_description,
            logoResId = R.drawable.still_life,
            id = 3
        ),
        BrandData(
            nameResId = R.string.brand_Abstract ,
            logoDescriptionResId = R.string.brand_abstract_description,
            logoResId = R.drawable.abstract_photo,
            id = 4
        )
    )
}