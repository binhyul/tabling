package com.example.tabling.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tabling.R
import com.example.tabling.databinding.ShopBinding
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
        val tags: List<String>?
    )

    private val binding: ShopBinding =
        ShopBinding.inflate(LayoutInflater.from(context), this)

    init {
        foreground = AppCompatResources.getDrawable(context, R.drawable.bg_selectable_item)
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
    }
}