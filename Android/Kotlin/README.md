## Kotlin

### Function
Another form of main accepts a variable number of String arguments.
```kotlin
fun main(args: Array<String>) {
    println(args.contentToString())
}
```

A function body can be an expression. Its return type is inferred.

```kotlin
fun sum(a: Int, b: Int) = a + b
```
