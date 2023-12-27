package com.example.music_app_ui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SubscriptionPage(){
    Column(
        Modifier.height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = "Manage Subsciption", color = Color.Black)
        Card(modifier =Modifier.padding(8.dp), elevation = 4.dp) {
            Column(Modifier.padding(8.dp)){

                Column(){
                    Text(text = "Musical",color = Color.Black)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Free Teir",color = Color.Black)
                        TextButton(onClick = { /*TODO*/ }) {
                            Row {
                                Text(text = "See All Plans")
                                androidx.compose.material.Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = "See all plans"
                                )
                            }
                        }
                    }
                }
                Divider(thickness = 1.dp, modifier = Modifier.padding(horizontal = 8.dp))
                Row(Modifier.padding(vertical = 16.dp)){
                    androidx.compose.material.Icon(imageVector = Icons.Default.AccountBox,
                        contentDescription = "Get a Plan")
                    Text(text = "Get a Plan",color = Color.Black)
                }
            }


        }

        }
}

@Composable
@Preview
fun SubscriptionPagePreview(){
    SubscriptionPage()
}
