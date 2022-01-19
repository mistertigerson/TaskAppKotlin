package com.example.taskapp.domain

data class ShopItem(

    var name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
)   {
    companion object{
        const val UNDEFINED_ID = -1
    }
}
