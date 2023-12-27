package com.example.music_app_ui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.music_app_ui.R
import com.example.music_app_ui.Screen

@Composable
fun BrowseScreen(){
    val categories = listOf("Hits","Happy","Workout","Running","Yoga","Retro")
    LazyVerticalGrid(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), columns = GridCells.Fixed(2)){
        items(categories){
            cat->
                BrowserItem(Cat = cat, drawbles = R.drawable.library)
        }
    }
}


@Preview
@Composable
fun BrowseScreenPreview(){
    BrowseScreen()
}