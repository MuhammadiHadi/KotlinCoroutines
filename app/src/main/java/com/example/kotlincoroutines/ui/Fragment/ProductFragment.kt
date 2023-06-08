package com.example.kotlincoroutines.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincoroutines.Api.ApiService
import com.example.kotlincoroutines.Api.RetrofitHelper
import com.example.kotlincoroutines.Repository.ProductListRepo
import com.example.kotlincoroutines.Utils.NetworkResult
import com.example.kotlincoroutines.ViewModel.ProductListItemVMFactory
import com.example.kotlincoroutines.ViewModel.ProductListVm
import com.example.kotlincoroutines.databinding.FragmentProductBinding
import com.example.kotlincoroutines.model.ProductItem
import com.example.kotlincoroutines.ui.Adapter.ProductListAdapter

class ProductFragment : Fragment() {
    private var _binding : FragmentProductBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel : ProductListVm
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View {
        _binding = FragmentProductBinding.inflate(inflater , container , false)
        val result = RetrofitHelper.getProductList().create(ApiService::class.java)
        val repoProduct = ProductListRepo(result)
        viewModel = ViewModelProvider(this ,
            ProductListItemVMFactory(repoProduct)).get(ProductListVm::class.java)

        return binding.root
    }

    override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        viewModel.getItem()

        viewModel.listLive.observe(viewLifecycleOwner , Observer { it ->
            when (it) {
                is NetworkResult.Success -> {
                    val response = it.data as ProductItem
                    binding.apply {
                        rvProductItem.layoutManager = LinearLayoutManager(requireContext())
                        rvProductItem.setHasFixedSize(true)
                        rvProductItem.adapter = ProductListAdapter(response.products)
                    }

                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }


        })
    }


}