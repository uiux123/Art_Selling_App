package com.example.watch_selling_app.presentation.screen.Favorite_Screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.watch_selling_app.domain.model.BottomNavItem
import com.example.watch_selling_app.domain.model.ProductData
import com.example.watch_selling_app.presentation.components.BackIconButton
import com.example.watch_selling_app.presentation.components.BottomNavigationBar
import com.example.watch_selling_app.presentation.components.product.FavoriteProductCard
import com.example.watch_selling_app.presentation.screen.Login_Screen.getSafeString
import com.example.watch_selling_app.ui.theme.Dimens
import com.example.watch_selling_app.utils.FavoritesManager

@Composable
fun FavoriteScreen(
    navItems: List<BottomNavItem>,
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit,
    onBackClick: () -> Unit
) {
    var refreshTrigger by remember { mutableStateOf(0) }
    val favoriteProducts = remember(refreshTrigger) { FavoritesManager.getFavorites() }

    Column(modifier = Modifier.fillMaxSize()) {

        // Top bar with back icon and title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.SpacingM)
        ) {
            BackIconButton(
                onClick = onBackClick,
                descriptionKey = getSafeString("back_button_description"),
            )
            Spacer(modifier = Modifier.width(Dimens.SpacingS))
            Text(
                text = getSafeString("favorite_screen_title"),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(Dimens.SpacingS))

        // Grid of favorite products
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Dimens.SpacingM),
            verticalArrangement = Arrangement.spacedBy(Dimens.SpacingM),
            horizontalArrangement = Arrangement.spacedBy(Dimens.SpacingM)
        ) {
            items(favoriteProducts) { product ->
                FavoriteProductCard(
                    product = product,
                    onRemoveFavorite = {
                        FavoritesManager.removeFavorite(product)
                        refreshTrigger++
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Bottom navigation bar
        BottomNavigationBar(
            items = navItems,
            selectedItem = selectedItem,
            onItemSelected = onItemSelected,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Dimens.SpacingS)
        )
    }
}
