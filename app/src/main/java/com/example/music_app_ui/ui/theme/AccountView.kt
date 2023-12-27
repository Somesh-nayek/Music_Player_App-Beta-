package com.example.music_app_ui.ui.theme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.music_app_ui.R
import com.example.music_app_ui.Screen

@Composable

fun AccountView(){
    Column(
        Modifier
            .fillMaxHeight()
            .padding(16.dp))
    {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Row (){
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    modifier = Modifier.padding(end = 8.dp))
                Column {
                    Text(text = "My_tutorials")
                    Text(text = "@Great_China_Wall")
                }
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null)

            }
        }
        Row(Modifier.padding(top = 16.dp)){
          Icon(painter = painterResource(id = R.drawable.ic_music),
              contentDescription = null,
              Modifier.padding(end = 8.dp))
            Text(text = "My Music")

        }
    }
}

@Composable
@Preview
fun AccountViewPreview(){
    AccountView()
}