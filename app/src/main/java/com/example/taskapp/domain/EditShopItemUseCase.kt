package com.example.taskapp.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository){

    fun editShopItem(shopItem: ShopItem, name: String){
        shopListRepository.editShopItem(shopItem, name)
    }

}