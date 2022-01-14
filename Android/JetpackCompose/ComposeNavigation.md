## Home.kt

```kotlin
@Composable
fun Home(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {

            },
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(5.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            }
        )

        Text(text = "Home")
        LazyColumn(modifier = Modifier.padding(bottom = 16.dp)) {
            var i = 0
            items((0..5).toList()) {
                TaskCard("Task ${++i}", navController)
            }
        }
    }
}

@Composable
fun TaskCard(name: String, navController: NavHostController? = null) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
                navController?.navigate("task/$name") // navController?.navigate("task?item=$name") [when using optional param]
            }
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_account_box_24),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
            )
            Text(text = name)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Home()
    }
}
```

## Task.kt
```kotlin
@Composable
fun Task(navController: NavHostController? = null, item: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(text = "Task Detail: $item")
        LazyColumn {
            var i = 0
            items((0..5).toList()) {
                TaskCard("Detailed item ${++i}")
            }
        }
    }
}
```

## MainContent.kt
```kotlin
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
```
