package com.example.taskapp.domain

class DeleteItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem): ShopItem{
        return  shopListRepository.deleteShopItem(shopItem)
    }
}