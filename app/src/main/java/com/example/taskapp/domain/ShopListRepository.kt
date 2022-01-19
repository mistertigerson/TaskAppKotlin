package com.example.taskapp.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem) : ShopItem

    fun getShopList():List<ShopItem>

    fun editShopItem(shopItem: ShopItem, name: String)

    fun getShopItem(shopItem: ShopItem): ShopItem

}