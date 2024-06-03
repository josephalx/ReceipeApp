package com.example.receipeapppractice.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry

@Composable
fun FirstScreen(navigate:(String)->Unit) {
    var name by remember {
        mutableStateOf(" ")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen One", color = Color.Black, style = TextStyle(fontSize = 32.sp))
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), value = name, onValueChange = {
            name = it
        })
        Button(onClick = { navigate("secondScreen") }) {
            Text(text = "Next Screen")
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen({})
}