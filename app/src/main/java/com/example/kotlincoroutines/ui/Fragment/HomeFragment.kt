package com.example.kotlincoroutines.ui.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincoroutines.databinding.FragmentHomeBinding
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var count : Int = 0
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
        _binding = FragmentHomeBinding.inflate(inflater , container , false)
        binding.button.setOnClickListener {
            increase()

            //log statement
            Log.d(TAG,"${Thread.currentThread().name}")

        }
        binding.btnD0.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                taskOne()
            }
            CoroutineScope(Dispatchers.Main).launch {
                taskTwo()
            }

        }


        return binding.root
    }

    private fun increase() {
        count++
        binding.tvCount.text= count.toString()

    }

   suspend  fun taskOne(){
        Log.d(TAG,"start task one")
        yield()
        Log.d(TAG,"end Task One")
    }
   suspend  fun taskTwo(){
        Log.d(TAG,"start task Two")
        yield()
        Log.d(TAG,"end Task Two")
    }
}