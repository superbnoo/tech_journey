package com.zuh.learncompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// single value: uses mutableStateOf()

//    val users = remember {
//        mutableStateListOf(User(1))
//    }
//    Box(modifier= Modifier.fillMaxSize()) {
//        UserList(users = users)
//        Button(modifier = Modifier
//            .padding(24.dp)
//            .align(Alignment.BottomCenter),
//            onClick = {
//                users.add(User(1))
//            }) {
//            Text("Add More")
//        }
//    }
@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                Home(navController)
            }
            composable(
                "task/{item}", // optional param: "task?item={item}",
                arguments = listOf(navArgument("item") {
                    type = NavType.StringType
                    // defaulValue = "Item not available" [needs when using optional param]
                })
            ) {
                val item = it.arguments?.getString("item") ?: ""
                Task(item = item)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MainContent()
}