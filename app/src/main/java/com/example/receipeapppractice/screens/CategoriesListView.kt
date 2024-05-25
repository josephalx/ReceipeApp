package com.example.receipeapppractice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.receipeapppractice.R
import com.example.receipeapppractice.model.Categories
import com.example.receipeapppractice.viewModel.MainViewModel

@Composable
fun CategoriesListComposable(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val categoriesList by viewModel.categoriesList

    Box(modifier = modifier.fillMaxSize()) {
        when {
            categoriesList.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            categoriesList.error != null -> {
                Text(
                    "Error while loading.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            categoriesList.categoriesList.isNotEmpty() -> {
                CategoryList(categoriesList.categoriesList)
            }
        }
    }
}

@Composable
fun CategoryList(categoriesList: List<Categories>) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categoriesList) {
            CategoriesItem(categories = it)
        }
    }
}

@Composable
fun CategoriesItem(categories: Categories) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                categories.thumbNail,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground)
            ),
            contentDescription = categories.description,
            modifier = Modifier
                .aspectRatio(1f)
        )
        Text(
            text = categories.categoryName,
            color = Color.Black,
            fontSize = 20.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview
@Composable
fun CategoriesPrev() {
    val category =
        Categories(
            id = "3",
            categoryName = "Dessert",
            description = "",
            thumbNail = ""
        )
    val list = listOf<Categories>(category, category, category)
    CategoryList(list)
}
