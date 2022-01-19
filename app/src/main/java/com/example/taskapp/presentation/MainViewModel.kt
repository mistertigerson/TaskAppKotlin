package com.example.taskapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskapp.data.ShopListRepositoryImpl
import com.example.taskapp.data.ShopListRepositoryImpl.editShopItem
import com.example.taskapp.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemListUseCase = GetShopItemListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    private val _shopList = MutableLiveData<List<ShopItem>>()
    public val shopList: LiveData<List<ShopItem>> = _shopList

    private val _delList = MutableLiveData<List<ShopItem>>()
    public val delList: LiveData<List<ShopItem>> = _delList

    private val _loading = MutableLiveData<Boolean>()
    public val loading: LiveData<Boolean> = _loading

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopItemList() {
        val list = getShopItemListUseCase.getShopList()
        _shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItemFun(shopItem: ShopItem, name: String){
        editShopItemUseCase.editShopItem(shopItem,name)
    }

    fun getShopItemFun(shopItem: ShopItem){
        getShopItemUseCase.getShopItem(shopItem)
    }
}