
### Merge a bunch of flow
```
    private suspend fun testFlow() {
        val test = listOf(1,2,3,4,5,6,7,8,9,10)
        val flowList = test.map {
            flow {
                delay(300L)
                emit(it)
            }
        }
        val result = arrayListOf<Int>()
        flowList.merge().collect {
            result.add(it)
        }
        android.util.Log.d("debug", "$result")
    }

    fun testCoroutineCall() {
        onIO {
            testFlow()
        }
    }
    ...
    // call
    viewModel.testCouroutineCall() // [1, 3, 4, 6, 8, 9, 2, 5, 7, 10]
```
