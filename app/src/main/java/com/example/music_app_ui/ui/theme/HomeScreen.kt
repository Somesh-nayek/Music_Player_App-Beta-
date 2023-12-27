package com.example.music_app_ui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){


    val categories = listOf("Hits","Happy","Workout","Running","Yoga")
    val group = listOf<String>("New Release","Favorites","Top Rated").groupBy {it[0]}
    LazyColumn{
        group.forEach{
            stickyHeader { 
                Text(text = it.value[0], modifier = Modifier.padding(16.dp), color = Color.Black)
                LazyRow{
                    items(categories){
                        cat->
                            BrowserItem(Cat = cat, drawbles = R.drawable.baseline_playlist_play_24)
                    }
                }
            }
        }
    }
}
@Composable
fun BrowserItem(Cat:String,drawbles:Int){

    Card(modifier= Modifier
        .padding(16.dp)
        .size(200.dp),
        border = BorderStroke(3.dp, color = Color.DarkGray)) {

        
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = Cat)
                Image(painter = painterResource(id = drawbles), contentDescription = Cat)
            }
    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}