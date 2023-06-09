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
import com.example.kotlincoroutines.databinding.FragmentSendDataBinding

class SendDataFragment : Fragment() {
    private var _binding:FragmentSendDataBinding?=null
    private  val binding get() = _binding!!
    lateinit var viewModel:ShareViewModel

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
       _binding=FragmentSendDataBinding.inflate(inflater,container,false)



        viewModel=ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        binding.btnSend.setOnClickListener {
            val value=binding.etSend.text.toString().trim()
            viewModel.setData(value)
            if(value.isNotEmpty()){
                findNavController().navigate(R.id.action_sendFragment_to_receiveFragment)
            }else{
                Toast.makeText(requireContext(), "Enter same-think" , Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}