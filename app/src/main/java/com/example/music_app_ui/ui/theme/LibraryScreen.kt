package com.example.music_app_ui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.music_app_ui.data.Lib
import com.example.music_app_ui.data.libraries

@Composable
fun LibraryScreen(){
    LazyColumn(){
        items(libraries){
            lib->
            LibItem(library = lib)
        }
    }
}
@Composable
fun LibItem(library:Lib){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Row {
                Icon(painter = painterResource(id = library.icon), contentDescription = library.name)
                Text(text = library.name)
            }
            Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight, contentDescription = "")
        }
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray, thickness = 1.dp,)
    }
}
@Preview
@Composable
fun LibraryScreenPreview(){
    LibraryScreen()
}