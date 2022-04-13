package com.example.composenotification

import androidx.lifecycle.ViewModel
import com.example.composenotification.ui.theme.ItemsList
import com.example.composenotification.ui.theme.Repository

class MyViewModel : ViewModel() {


    val repo = Repository()
    var page = 1
    fun loadMore() : List<ItemsList> {
        val newlist = repo.getresultapi(page, 20)
        page = page + 1
        return newlist.getOrNull()!!
    }
}