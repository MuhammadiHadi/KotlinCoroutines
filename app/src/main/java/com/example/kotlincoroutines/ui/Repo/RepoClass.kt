package com.example.kotlincoroutines.ui.Repo

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

class RepoClass  @Inject constructor(){


    fun userLogin(username:String, password:String){
        Log.d(TAG,"Hello World")
    }
}