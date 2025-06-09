package com.example.watch_selling_app.presentation.screen.Home_Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.watch_selling_app.data.dataSource.*
import com.example.watch_selling_app.domain.model.BottomNavItem
import com.example.watch_selling_app.domain.model.BrandData
import com.example.watch_selling_app.domain.model.ProductData
import com.example.watch_selling_app.presentation.components.BottomNavigationBar
import com.example.watch_selling_app.presentation.components.brand.BrandListSection
import com.example.watch_selling_app.presentation.components.carouselSlider.Carousel
import com.example.watch_selling_app.presentation.components.product.CasualWatchSection
import com.example.watch_selling_app.presentation.components.product.ProductListSection
import com.example.watch_selling_app.ui.theme.Dimens
import com.example.watch_selling_app.utils.FavoritesManager
import com.example.watch_selling_app.R
import com.example.watch_selling_app.presentation.components.product.LadyWithFanSection
import com.example.watch_selling_app.presentation.components.product.MadonaChildSection
import com.example.watch_selling_app.presentation.components.product.TheKissSection

@Composable
fun HomeScreen(
    onProductClick: (ProductData) -> Unit,
    navItems: List<BottomNavItem>,
    selectedItem: BottomNavItem,
    onNavigateTo: (String) -> Unit
) {
    val topBarContent = DataSource.getTopBarContent()
    val searchBarContent = DataSource.getSearchBarContent()
    val carouselPartContent = CarouselDataSource.getCarouselItems()
    val products = PearlGirlDataSource.getProducts()
    val casualWatches = CasualProductDataSource.getCasualWatches()
    val brands = BrandDataSource.getBrands()

    val madonaChild = MadonaDataSource.getMadonaPictures()
    val ladywithfan = LadyWithFanDataSource.getLadyWithFanPictures()

    val thekiss = TheKissDataSource.theKissPictures()

    var selectedBrand by remember { mutableStateOf<BrandData?>(null) }

    var refreshTrigger by remember { mutableStateOf(0) }

    Scaffold(

        contentWindowInsets = WindowInsets(left = 0.dp, top = Dimens.SpacingM, right = 0.dp, bottom = 0.dp),
        bottomBar = {
            BottomNavigationBar(
                items = navItems,
                selectedItem = selectedItem,
                onItemSelected = { item ->
                    onNavigateTo(item.route)
                }
            )
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                var text by remember {
                    mutableStateOf("")
                }

                Icon(imageVector = Icons.Filled.List,contentDescription = null, modifier = Modifier.size(
                    Dimens.backButtonSize)
                )

                Spacer(modifier = Modifier.width(Dimens.SpacingS))

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = {
                        Text(text = stringResource(id = R.string.search_arts))
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search icon"
                        )
                    },
                    modifier = Modifier
                        .padding(Dimens.SpacingL)// Optional
                )
            }



            Carousel(items = carouselPartContent)

            BrandListSection(
                brands = brands,
                selectedBrand = selectedBrand,
                onBrandSelected = { brand ->
                    selectedBrand = brand
                },
                modifier = Modifier.padding(top = Dimens.SpacingM)
            )
            ProductListSection(

                products = products,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onFavoriteClick = { product ->
                    FavoritesManager.toggleFavorite(product)
                    refreshTrigger++
                },
                refreshTrigger = refreshTrigger
            )

            CasualWatchSection(
                products = casualWatches,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onFavoriteClick = { product ->
                    FavoritesManager.toggleFavorite(product)
                    refreshTrigger++
                }
            )

            MadonaChildSection(
                products = madonaChild,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onFavoriteClick = { product ->
                    FavoritesManager.toggleFavorite(product)
                    refreshTrigger++
                },
                refreshTrigger = refreshTrigger
            )

            LadyWithFanSection(


                products = ladywithfan,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onFavoriteClick = { product ->
                    FavoritesManager.toggleFavorite(product)
                    refreshTrigger++
                },
                refreshTrigger = refreshTrigger
            )

            TheKissSection(

                products = thekiss,
                onProductClick = { product ->
                    onProductClick(product)
                },
                onFavoriteClick = { product ->
                    FavoritesManager.toggleFavorite(product)
                    refreshTrigger++
                },
                refreshTrigger = refreshTrigger
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingL))
        }
    }
}
