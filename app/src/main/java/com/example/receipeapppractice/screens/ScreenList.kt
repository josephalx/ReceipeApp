package com.example.receipeapppractice.screens

sealed class ScreenList(val route: String) {
    data object CategoryListScreen : ScreenList("categoryList")
    data object CategoryDetailScreen : ScreenList("categoryDetailScreen")
}