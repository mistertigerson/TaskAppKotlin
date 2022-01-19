package com.example.taskapp.domain

class GetShopItemListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList() = shopListRepository.getShopList()


}