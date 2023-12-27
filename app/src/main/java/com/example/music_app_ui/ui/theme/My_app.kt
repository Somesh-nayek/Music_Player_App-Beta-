package com.example.music_app_ui.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.music_app_ui.R
import com.example.music_app_ui.Screen
import com.example.music_app_ui.mainViewModel
import com.example.music_app_ui.screenInDrawer
import com.example.music_app_ui.screensINBottom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class,ExperimentalMaterialApi::class)
@Composable
fun My_App(){
        val scaffoldState: ScaffoldState = rememberScaffoldState()
        val scope:CoroutineScope = rememberCoroutineScope()
    val viewmodel:mainViewModel = viewModel()
//    Tbis three lines underneath helps us to find out on which view or screen we are currently in
    val controller:NavController = rememberNavController()
    val navBackstackEntry by controller.currentBackStackEntryAsState()
    val currentRoute =navBackstackEntry?.destination?.route


    val dialogOpen =remember{
        mutableStateOf(false)
    }
    val currentScreen =remember{
        viewmodel.currentScreen.value
    }
    val title = remember{
//        change that to currentScreen.title
        mutableStateOf(currentScreen.title)
    }
    val isSheetFullScreen by remember { mutableStateOf(false) }
    val modifier=if(isSheetFullScreen)Modifier.fillMaxSize()else Modifier.fillMaxWidth()

    val modalSheetState = androidx.compose.material.rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val roundedCornerRadius =if(isSheetFullScreen)0.dp else 12.dp
    val bottomBar: @Composable ()->Unit={
        if(currentScreen is Screen.DrawerScreen || currentScreen==Screen.BottomScreen.Home){
            BottomNavigation(Modifier.wrapContentSize()){
                        screensINBottom.forEach{
                            item->
                            val isSelected =currentRoute==item.bRoute
                            Log.d("Navigation","Item:${item.bTitle},Current Route:${currentRoute},Is selected")
                            val tint=if(isSelected) Color.White else Color.Black
                            BottomNavigationItem(selected = currentRoute==item.bRoute,
                                onClick = {controller.navigate(item.bRoute)
                                          title.value=item.bTitle}, icon = {

                                    Icon(
                                        painter = painterResource(id = item.Icon), contentDescription = item.bTitle,tint= tint)
                                },
                                label = { Text(text = item.bTitle, color = tint)}
                                , selectedContentColor = Color.White,
                                unselectedContentColor = Color.Black
                                )
            }
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetContent = {
        MoreBottomSheet(modifier= modifier)}) {
        Scaffold(
            bottomBar = bottomBar,
            topBar = { TopAppBar(title = { Text(text = title.value, color = Color.DarkGray)},
                actions = {
                          androidx.compose.material.IconButton(
                              onClick = {
                                  scope.launch {
                                      if(modalSheetState.isVisible)
                                          modalSheetState.hide()
                                      else
                                          modalSheetState.show()
                                  }
                              }) {
                              Icon(imageVector = Icons.Default.MoreVert,
                                  contentDescription = null)

                          }
                },
                navigationIcon = { IconButton(onClick = {
//                open the drawer
                    scope.launch { scaffoldState.drawerState.open() }
                })

                {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")

                }}
            )
            },scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(Modifier.padding(16.dp)){
                    items(screenInDrawer){ item->
                        DrawerItem(selected =currentRoute==item.dRoute , item =item ) {
                            scope.launch {
//                            helps to close the drawer whenever something other than the drawer is clicked
                                scaffoldState.drawerState.close()
                            }
                            if(item.dRoute=="Add_account"){
                                dialogOpen.value=true
                            }else{
                                controller.navigate(item.dRoute)
                                title.value=item.dTitle
                            }
                        }
                    }
                }
            }

        ){
            Navigation(navController = controller, pd = it)
            AccountDialog(dialogOpen = dialogOpen)
        }
    }



}




@Composable
fun DrawerItem(
    selected:Boolean,
    item:Screen.DrawerScreen,
    onDrawerItemClicked:()->Unit
){
    val background=if(selected) Color.Gray else Color.White
    Row (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ){
        Icon(painter = painterResource(id = item.Icon),
            contentDescription = item.dTitle,
            Modifier.padding(end = 8.dp,top=4.dp))
        Text(text = item.dTitle,
            style = MaterialTheme.typography.headlineMedium, color = Color.Black
        )
    }
}


@Composable
fun Navigation(navController: NavController,pd: PaddingValues){
    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route,
        modifier = Modifier.padding(pd)){
        composable(Screen.DrawerScreen.Account.route){
                AccountView()
        }
        composable(Screen.DrawerScreen.Subsciption.route){
            SubscriptionPage()
        }
        composable(Screen.BottomScreen.Home.bRoute){
            HomeScreen()
        }
        composable(Screen.BottomScreen.Browse.bRoute){
            BrowseScreen()
        }
        composable(Screen.BottomScreen.LIbrary.bRoute){
            LibraryScreen()
        }
    }
}

@Composable
fun MoreBottomSheet(modifier: Modifier){
    Box (
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(androidx.compose.material.MaterialTheme.colors.primarySurface)
    ){
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween){
            Row(Modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.setting) ,
                    contentDescription = "Settings")
                Text(text = "Settings", color = Color.Black, fontSize = 20.sp)
            }
            Row(Modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.rate_app) ,
                    contentDescription = "Rate our app")
                Text(text = "Rate our App", color = Color.Black, fontSize = 20.sp)
            }
            Row(Modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.share) ,
                    contentDescription = "Share")
                Text(text = "Share", color = Color.Black, fontSize = 20.sp)
            }
        }
    }
}