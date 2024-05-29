package com.example.receipeapppractice.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry

@Composable
fun SecondScreen(navigate: (String) -> Unit, name:String?) {
    Column(  modifier = Modifier
        .fillMaxSize()
        .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Screen Two", color = Color.Black, style = TextStyle(fontSize = 32.sp))
        Text(text = "Welcome $name")
        Button(onClick = { navigate("firstScreen") }) {
            Text("Go Back")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen({}, "")
}