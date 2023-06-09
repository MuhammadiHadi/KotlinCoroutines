package com.example.kotlincoroutines.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.Repository.ProductListRepo
import javax.inject.Inject

class ProductListItemVMFactory @Inject constructor(val listRepo :ProductListRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductListVm(listRepo) as T
    }

}