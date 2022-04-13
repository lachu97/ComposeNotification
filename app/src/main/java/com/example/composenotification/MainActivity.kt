package com.example.composenotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenotification.ui.theme.ComposeNotificationTheme
import com.example.composenotification.ui.theme.ItemsList
import com.example.composenotification.utils.funnyLists

class MainActivity : ComponentActivity() {
    val vm by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotificationTheme {

                val mylist = listOf<ItemsList>(
                    ItemsList("Name",34),
                    ItemsList("MyName",3),
                    ItemsList("Howdy",4),
                    ItemsList("Abiname",324),
                    ItemsList("Howzat",314),
                )
                val customlist = vm.loadMore()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    funnyLists(list = customlist,vm)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotificationTheme {
        Greeting("Android")
    }
}