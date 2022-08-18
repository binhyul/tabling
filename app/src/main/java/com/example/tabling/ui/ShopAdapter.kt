package com.example.tabling.ui

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tabling.component.ShopView
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
            render(
                ShopView.State(
                    model.category,
                    model.title,
                    model.thumbnail,
                    model.rating.toString(),
                    model.reviewCount,
                    model.place,
                    model.waitingTeamCount,
                    model.tagStringRes?.map {
                        resources.getString(it)
                    }
                )
            )
        }
    }

}



 class ShopComponentItemDecoration(private val space: Int) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val orientation = (parent.layoutManager as LinearLayoutManager).orientation
        if (orientation == RecyclerView.VERTICAL) {
            outRect.bottom = space
        } else {
            outRect.right = space
        }
    }
}