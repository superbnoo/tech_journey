## Jetpack Compose
### Partly ComposeView in Fragment
```kotlin
class HomeFragment : Fragment(R.layout.home_framgment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            UserCard()
        }
    }
}
```

### Full ComposeView in Fragment
```kotlin
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                UserCard()
            }
        }
    }
}
```

### State in Compose
```kotlin
@Composable
fun MainContent() {
    // single value: uses mutableStateOf()

    val users = remember {
        mutableStateListOf(User(1))
    }
    Box(modifier= Modifier.fillMaxSize()) {
        UserList(users = users)
        Button(modifier = Modifier
            .padding(24.dp)
            .align(Alignment.BottomCenter),
            onClick = {
                users.add(User(1))
        }) {
            Text("Add More")
        }
    }
}
```

### RecyclerView in Compose
```kotlin
@Composable
fun UserList(users: List<User>) {

    LazyColumn {
        items(users) { user ->
            UserCard()
        }
    }
}
```

### Row, Column, Text, Image, modifier
```kotlin
@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            // alt + enter to open option to put params in separate line
            Image(
                painter = painterResource(id = R.drawable.ic_account_box_24),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
            )
            Column {
                Text(
                    text = stringResource(id = R.string.dummy_text)
                )
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}
```
