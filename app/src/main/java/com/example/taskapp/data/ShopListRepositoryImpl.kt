package com.example.taskapp.data

import com.example.taskapp.domain.ShopItem
import com.example.taskapp.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrement = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrement++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem): ShopItem {
        shopItem.name = ""
        shopItem.id = 0
        return shopItem
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun editShopItem(shopItem: ShopItem, name: String) {
        shopItem.name = name
    }

    override fun getShopItem(shopItem: ShopItem): ShopItem {
        return shopItem
    }


}