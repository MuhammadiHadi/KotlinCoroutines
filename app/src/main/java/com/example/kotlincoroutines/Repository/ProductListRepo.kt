package com.example.kotlincoroutines.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlincoroutines.Api.ApiService
import com.example.kotlincoroutines.Utils.NetworkResult
import com.example.kotlincoroutines.model.Product
import com.example.kotlincoroutines.model.ProductItem
import com.example.kotlincoroutines.model.ProductX

class ProductListRepo(private val apiService : ApiService) {

   private val _productListLive=MutableLiveData<NetworkResult<ProductItem>>()
     val listLive: LiveData<NetworkResult<ProductItem>>
     get() = _productListLive

    suspend fun getList(){
        val result=apiService.getProduct()
        if(result.isSuccessful){
            val response=result.body()
            println("response${response}")
            if(response!=null){
                _productListLive.postValue( NetworkResult.Success(response))
            }
            else{
                _productListLive.postValue(NetworkResult.Error( response.toString()))
            }

        }
    }
}