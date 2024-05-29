package com.example.receipeapppractice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.receipeapppractice.R
import com.example.receipeapppractice.model.Categories
import com.example.receipeapppractice.ui.theme.ReceipeAppPracticeTheme
import com.google.gson.Gson
import java.net.URLDecoder

@Composable
fun CategoryDetailsScreen(cat: String) {
    val catDecode = URLDecoder.decode(cat,"utf-8")
    val category = Gson().fromJson(catDecode,Categories::class.java)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = category.categoryName,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 32.sp))
        Image(
            painter = rememberAsyncImagePainter(
                category.thumbNail,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            ),
            contentDescription = "${category.description} Thumbnail",
            modifier = Modifier.aspectRatio(1f)
        )
        Text(text = category.description,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState()))
    }
    
}

@Preview
@Composable
fun CategoryDetailsScreenPreview() {
        val c = Categories("1","Beef","https://www.themealdb.com/images/category/beef.png","Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients")
        CategoryDetailsScreen("")

}