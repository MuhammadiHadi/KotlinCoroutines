package com.example.kotlincoroutines.ui.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.ViewModel.ShareViewModel
import com.example.kotlincoroutines.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel:ShareViewModel
    private var count : Int = 0

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
        _binding = FragmentHomeBinding.inflate(inflater , container , false)

        binding.btnFun.setOnClickListener {
         increase()
        }
        binding.button.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_sendFragment)
        }
        binding.btnD0.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_productFragment)
//            CoroutineScope(Dispatchers.Main).launch {
//                taskOne()
//            }
//            CoroutineScope(Dispatchers.Main).launch {
//                taskTwo()
//            }
//         CoroutineScope(Dispatchers.Main).async {
//             getValue()
//             task()
//         }

        }


        return binding.root
    }
    suspend fun getValue(){
     CoroutineScope(Dispatchers.IO).async {
       val task=  async { newTask() }
        val new= async { task() }

         Log.d(TAG, "${ task.await().toString()},${ new.await().toString() }")
        }
        // job object we are using for if complete then run other statement


    }

    private fun increase() {
        count++
        binding.tvCount.text= count.toString()

    }

   private suspend  fun taskOne(){
        Log.d(TAG,"start task one")
        yield()
        Log.d(TAG,"end Task One")
    }
   private suspend  fun taskTwo(){
        Log.d(TAG,"start task Two")
        yield()
        Log.d(TAG,"end Task Two")
    }

   private suspend fun newTask() : Int {
        delay(3000)
       return 20

    }
    // async we are using for waiting same time
     private suspend fun task():Int{
      delay(3000)
        return 30
     }
}