package com.example.music_app_ui.data

import androidx.annotation.DrawableRes
import com.example.music_app_ui.R

data class Lib(@DrawableRes val icon:Int,val name:String)

val libraries = listOf<Lib>(
    Lib(R.drawable.library,"Library"),
    Lib(R.drawable.artist,"Artist"),
    Lib(R.drawable.album,"Album"),
    Lib(R.drawable.ic_music,"Songs"),
    Lib(R.drawable.genre,"Genre")
)
