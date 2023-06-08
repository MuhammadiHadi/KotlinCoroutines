package com.example.kotlincoroutines.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.Repository.ProductListRepo

class ProductListItemVMFactory(val listRepo :ProductListRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductListVm(listRepo) as T
    }

}