package com.example.music_app_ui

import androidx.annotation.DrawableRes

sealed class Screen(val title:String,val route:String) {

    sealed class BottomScreen(val bTitle: String,
                              val bRoute:String,
                             @DrawableRes val Icon: Int
                                ):Screen(bTitle,bRoute){
                                    object Home:BottomScreen(
                                        bTitle = "Home",
                                        bRoute = "home",
                                        R.drawable.home_button
                                    )
        object Browse:BottomScreen(
            bTitle = "Browse",
            bRoute = "browse",
            R.drawable.browse
        )
        object LIbrary:BottomScreen(
            bTitle = "Library",
            bRoute = "library",
            R.drawable.library
        )
                                }

    sealed class DrawerScreen(val dTitle:String,val dRoute:String,@DrawableRes val Icon:Int):Screen(dTitle,dRoute){

        object Account:DrawerScreen(
            "Account",
            "account",
            R.drawable.baseline_person_24
        )
        object Subsciption:DrawerScreen(
            "Subscription",
            "subscription",
            R.drawable.baseline_subscriptions_24
        )
        object AddAccount:DrawerScreen(
            "Add Account",
            "Add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
    }
}
val screensINBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.LIbrary
)
val screenInDrawer= listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subsciption
)