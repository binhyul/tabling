package com.example.tabling.component

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tabling.R
import com.example.tabling.databinding.ShopBinding
import com.example.tabling.databinding.ViewShopTagBinding
import com.example.tabling.loadUrlImage

class ShopView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    data class State(
        val category: String,
        val title: String,
        val thumbnail: String,
        val rating: String,
        val reviewCount: Int,
        val place: String,
        val waitingTeam: Int,
        val like: Boolean,
        val tags: List<String>?
    )

    private val binding: ShopBinding =
        ShopBinding.inflate(LayoutInflater.from(context), this)

    private val tagAdapter = ShopTagAdapter()

    init {
        foreground = AppCompatResources.getDrawable(context, R.drawable.bg_selectable_item)
        binding.rvTag.adapter = tagAdapter
        binding.rvTag.addItemDecoration(
            ShopTagComponentItemDecoration(
                resources.getDimensionPixelOffset(
                    R.dimen.shop_tag_view_offset
                )
            )
        )
    }

    fun render(state: State) {
        binding.tvCategory.text = state.category
        binding.ivImg.loadUrlImage(state.thumbnail)
        binding.tvTitle.text = state.title
        binding.tvPlace.text = state.place

        val reviewCountText = if (state.reviewCount > 300) {
            resources.getString(R.string.shop_review_count_over)
        } else {
            state.reviewCount.toString()
        }
        binding.tvRating.text =
            resources.getString(R.string.shop_rating, state.rating, reviewCountText)


        val waitingTeamNotification = if (state.waitingTeam == 0) {
            resources.getString(R.string.no_waiting)
        } else {
            resources.getString(R.string.waiting_team, state.waitingTeam)
        }
        binding.tvWaiting.text = waitingTeamNotification
        binding.ivLike.setImageResource(
            if (state.like) {
                R.drawable.ic_heart_filled_24
            } else {
                R.drawable.ic_heart_empty_24
            }
        )
        tagAdapter.submitList(state.tags)
    }


    private class ShopTagAdapter :
        ListAdapter<String, ShopTagViewHolder>(object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }
        }) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopTagViewHolder {
            return ShopTagViewHolder(parent)
        }

        override fun onBindViewHolder(holder: ShopTagViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)
        }
    }


    private class ShopTagViewHolder(
        parent: ViewGroup,
    ) : RecyclerView.ViewHolder(
        ViewShopTagBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).root
    ) {

        private val binding = ViewShopTagBinding.bind(itemView)

        fun bind(tag: String) {
            with(binding.root) {
                text = tag
            }
        }

    }


    private class ShopTagComponentItemDecoration(private val space: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = space
        }
    }


}