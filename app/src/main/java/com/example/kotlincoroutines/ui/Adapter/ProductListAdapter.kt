package com.example.kotlincoroutines.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutines.databinding.ItemListLayoutBinding
import com.example.kotlincoroutines.model.ProductX


class ProductListAdapter(private val itemList : List<ProductX>)
    :RecyclerView.Adapter<ProductListAdapter.Holder>() {

   private lateinit var context:Context
    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : Holder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListLayoutBinding.inflate(layoutInflater, parent, false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder : Holder , position : Int) {
        val product=itemList[position]
        holder.bind(product)
    }

    override fun getItemCount() : Int {
        return itemList.size
    }

    inner class  Holder(private  val binding:ItemListLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(product :ProductX){
            binding.product=product
            binding.executePendingBindings()
        }
    }
}
