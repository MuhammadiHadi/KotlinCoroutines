package com.example.kotlincoroutines.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.Repository.ProductListRepo
import com.example.kotlincoroutines.Utils.NetworkResult
import com.example.kotlincoroutines.model.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListVm (private val productListRepo : ProductListRepo):ViewModel() {

    val listLive: LiveData<NetworkResult<ProductItem>>
    get()=productListRepo.listLive
    fun getItem(){
        viewModelScope.launch () {
            productListRepo.getList()
        }
    }
}