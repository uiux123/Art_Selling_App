package com.example.watch_selling_app.data.dataSource

import androidx.compose.ui.res.stringResource
import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.CarouselItem

object CarouselDataSource {
    fun getCarouselItems(): List<CarouselItem> = listOf(
        CarouselItem(R.drawable.banner_one, "carousel_1"),
        CarouselItem(R.drawable.banner_two, "carousel_1"),
        CarouselItem(R.drawable.banner_three, "carousel_1"),
        CarouselItem(R.drawable.banner_4, "carousel_1")
    )
}