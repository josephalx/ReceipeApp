package com.example.receipeapppractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.receipeapppractice.model.Categories
import com.example.receipeapppractice.screens.CategoriesListComposable
import com.example.receipeapppractice.screens.CategoryDetailsScreen
import com.example.receipeapppractice.screens.ScreenList
import com.example.receipeapppractice.ui.theme.ReceipeAppPracticeTheme
import com.example.receipeapppractice.viewModel.MainViewModel
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val categoriesViewModel = MainViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            ReceipeAppPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(categoriesViewModel = categoriesViewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(categoriesViewModel: MainViewModel) {
    val navController = rememberNavController()
    val navigate = { screen: String ->
        navController.navigate(screen)
    }
    NavHost(navController = navController, startDestination = ScreenList.CategoryListScreen.route) {
        composable(route = ScreenList.CategoryListScreen.route) {
            CategoriesListComposable(viewModel = categoriesViewModel, navigate = navigate)
        }
        composable(route = "${ScreenList.CategoryDetailScreen.route}/{category}",
            arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            val categoryString = it.arguments?.getString("category")?:""
            println("Category: $categoryString")
            CategoryDetailsScreen(cat = categoryString)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val categoriesViewModel = MainViewModel()
    ReceipeAppPracticeTheme {
        MyApp(categoriesViewModel = categoriesViewModel)
    }
}