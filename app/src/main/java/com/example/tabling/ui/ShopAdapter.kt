package com.example.tabling.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tabling.databinding.ViewShopBinding

class ShopAdapter :
    ListAdapter<ShopModel, ShopViewHolder>(object : DiffUtil.ItemCallback<ShopModel>() {
        override fun areItemsTheSame(
            oldItem: ShopModel,
            newItem: ShopModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ShopModel,
            newItem: ShopModel
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}


class ShopViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    ViewShopBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ).root
) {

    private val binding = ViewShopBinding.bind(itemView)

    fun bind(model : ShopModel){
        with(binding.root){
        }
    }

}