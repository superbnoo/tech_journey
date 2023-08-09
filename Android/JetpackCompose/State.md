### Question
The deference between this line
```
val text = remember{ mutableStateOf("") }
```

and this
```
val text = remember{ "" }
```

and this
```
val text = mutableStateOf("")
```

### Answer
`remember` is a composable function that can be used to cache expensive operations. You can think of it as a cache which is local to your composable.

```
val state: Int = remember { 1 }
```
The **state** in the above code is immutable. If you want to change that state and also update the UI, you can use a `MutableState`. **Compose** will observe any reads/writes the `MutableState` object and trigger a recomposition to update the UI.

```
val state: MutableState<Int> = remember { mutableStateOf(1) }

Text(
   modifier = Modifier.clickable { state.value += 1 },
   text = "${state.value}",
 )
```
Another variant (added in alpha12) called rememberSaveable which is similar to remember, but the stored value can survive process death or configuration changes.

```
val state: MutableState<Int> = rememberSaveable { mutableStateOf(1) }
```

**Note**: You can also use property delegates as a syntactic sugar to unwrap the MutableState.
```
var state: Int by remember { mutableStateOf(1) }
```

Regarding the last part of your question:

```
val text = mutableStateOf("")
```

Compose does observe the value of the state, in fact there's a @Stable annotation on top of it, and that's its sole responsibility, but since we're not remembering the state, a mutableStateOf(1) will always be created AGAIN, so there will be a new instance of a state, but will still have the same value of 1. So the state seems to not change, but there IS a recomposition happening.

