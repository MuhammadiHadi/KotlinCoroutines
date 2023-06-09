package com.example.kotlincoroutines.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.ViewModel.ShareViewModel
import com.example.kotlincoroutines.databinding.FragmentReceiveDataBinding

class ReceiveDataFragment : Fragment() {
    private var _binding:FragmentReceiveDataBinding?=null
    private val  binding get() = _binding!!
    lateinit var viewModel: ShareViewModel
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
        _binding=FragmentReceiveDataBinding.inflate(inflater,container,false)
        viewModel= ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        viewModel.data.value
        binding.textView.text=viewModel.data.value.toString()
        return binding.root
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.btnUpdate.setOnClickListener {
            val value=binding.etUpdate.text.toString().trim()
            viewModel.setData(value)
            if(value.isNotEmpty()){
             updateValue()

            }else{
                Toast.makeText(requireContext(), "Enter same-think" , Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun updateValue(){
        viewModel.data.observe(viewLifecycleOwner) {
            binding.textView.text = it.toString()
        }
        Toast.makeText(requireContext(), "update Success" , Toast.LENGTH_SHORT).show()
    }


}