package com.example.composenotification.utils

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composenotification.MyViewModel
import com.example.composenotification.ui.theme.ItemsList

@Composable
fun funnyLists(list: List<ItemsList>,vm:MyViewModel) {
    val state = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(), state = state
    ) {
        itemsIndexed(list) { idx, item ->
            Column {
                Text(text = item.name)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = item.number.toString())
                Divider()
            }
            val bool=state.firstVisibleItemIndex == list.size -1
            Log.i("Val","Bool = ${bool}")
            if(state.isScrolledToTheEnd()){
                val newlist = vm.loadMore()
                Log.i("ViewModels","Loaded Values = ${newlist}")
            }
        }
    }
}
fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1