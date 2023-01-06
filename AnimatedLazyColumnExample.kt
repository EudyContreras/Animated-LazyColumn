class ExampleViewModel: ViewModel() {
    val adapter: LazyAnimatedColumnAdapter<String> = LazyAnimatedColumnAdapter(emptyList(), isReversed = true)

    var counter: Int = 0

    fun addItem() {
        adapter.addItem("Item :$counter")
        counter ++
    }
    
    fun removeItem(index: Int) {
        adapter.removeItem(index)
    }
}

@Composable
fun AnimatedLazyColumnExample() {
    val viewModel: ExampleViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.weight(1f)) {
            val listState = rememberLazyListState()

            AnimatedLazyColumn(
                adapter = viewModel.adapter,
                state = listState,
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) { data ->
                Column(
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 12.dp)
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(vertical = 20.dp)
                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = data, fontSize = 16.sp)
                }
            }

        }
        Button(onClick = { viewModel.addItem()}) {
            Text(text = "Add item")
        }
    }
}
