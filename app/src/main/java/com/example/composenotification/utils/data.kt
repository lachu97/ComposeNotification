package com.example.composenotification.ui.theme

data class ItemsList(
    val name: String,
    val number: Int
)

class Repository {
    val items = (1..300).map {
        ItemsList(
            name = "Name ${it}",
            number = it
        )
    }
    fun getresultapi(page: Int, pagesize: Int): Result<List<ItemsList>> {
        val startindex = page * pagesize
        return if (startindex + pagesize <= items.size) {
            Result.success(items.slice(startindex until startindex + pagesize))
        } else {
            Result.success(emptyList())
        }
    }
}