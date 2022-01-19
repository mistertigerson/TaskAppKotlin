package com.example.taskapp.presentation

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskapp.R
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.domain.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.shopList.observe(this) {
            it.forEach { shopItem ->
                Log.e("TAG444", "list: ${shopItem}")
                binding.tvText.text = shopItem.name
                initListeners(shopItem)
                Toast.makeText(this, shopItem.toString(), Toast.LENGTH_SHORT).show()
            }

        }

        binding.getBtn.setOnClickListener{
            viewModel.shopList.observe(this){
                val shopItem: ShopItem = it[0]
                viewModel.getShopItemFun(shopItem)
                Toast.makeText(this, it[0].toString(), Toast.LENGTH_SHORT).show()

            }
        }

        binding.editBtn.setOnClickListener{
            viewModel.shopList.observe(this){
                val text = "text"
                viewModel.editShopItemFun(it[0],text)
                Toast.makeText(this, it[0].name, Toast.LENGTH_SHORT).show()
                binding.tvText.text = it[0].name
                Log.e(TAG, "onCreate: ${it[0]}", )
            }
        }


        binding.startTv.setOnClickListener {
            addShopItemfun()
        }

    }

    private fun initListeners(shopItem: ShopItem) {

        binding.deleteBtn.setOnClickListener {
            viewModel.deleteShopItem(shopItem)
            Toast.makeText(this, shopItem.toString(), Toast.LENGTH_SHORT).show()

        }
    }



    private fun addShopItemfun() {
        viewModel.addShopItem(ShopItem("Potato", 2, false, 1))
        viewModel.getShopItemList()

    }
}