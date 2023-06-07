package com.example.kotlincoroutines.ui.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.databinding.FragmentHomeBinding
import com.example.kotlincoroutines.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    private  var _binding: FragmentSplashScreenBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
       _binding=FragmentSplashScreenBinding.inflate(inflater,container ,false)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        },3000)
        return binding.root
    }


}