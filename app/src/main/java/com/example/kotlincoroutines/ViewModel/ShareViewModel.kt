package com.example.kotlincoroutines.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ShareViewModel  :ViewModel() {
    private val _data=MutableLiveData<String>()
    val data:LiveData<String>
    get() = _data
    fun setData(value:String){
        viewModelScope.launch {
            _data.postValue(value)
        }

    }


}