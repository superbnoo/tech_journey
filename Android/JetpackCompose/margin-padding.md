### Margin & Padding in Compose

You can consider padding and margin as the same thing (imagine it as "spacing"). A padding can be applied twice (or more) in the same composable and achieve the similar behavior you would get with margin+padding. For example:

```kotlin
val shape = CircleShape
Text(
    text = "Text 1",
    style = TextStyle(
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center),
    modifier = Modifier.fillMaxWidth()
        .padding(16.dp)
        .border(2.dp, MaterialTheme.colors.secondary, shape)
        .background(MaterialTheme.colors.primary, shape)
        .padding(16.dp)
)
```

Will result on this:

![Image](https://i.stack.imgur.com/oqLvk.png)

As you can see, the first `padding` is adding a space between the component and its border. Then the background and border are defined. Finally, a new `padding` is set to add space between the border and the text.
