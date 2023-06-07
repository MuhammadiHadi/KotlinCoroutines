package com.example.kotlincoroutines.ui.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincoroutines.databinding.FragmentHomeBinding
import com.example.kotlincoroutines.ui.Repo.RepoClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var count : Int = 0
    @Inject
    lateinit var repo:RepoClass
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
        _binding = FragmentHomeBinding.inflate(inflater , container , false)
        binding.button.setOnClickListener {
            increase()

            // log statement
            Log.d(TAG,"${Thread.currentThread().name}")

        }
        binding.btnD0.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                taskOne()
            }
            CoroutineScope(Dispatchers.Main).launch {
                taskTwo()
            }
         CoroutineScope(Dispatchers.Main).async {
             getValue()
             task()
         }

        }
     repo.userLogin("hadi@gmail.com","12345678")

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