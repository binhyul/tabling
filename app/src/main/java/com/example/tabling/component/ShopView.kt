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
        val categories : List<String>,
        val title: String,
        val thumbnail: String,
        val rating : Float,
        val place : String,
        val tags : List<String>?
    )

    private val binding: ShopBinding =
        ShopBinding.inflate(LayoutInflater.from(context), this)

    init {
        foreground = AppCompatResources.getDrawable(context, R.drawable.bg_selectable_item)
    }

    fun setState(state: State) {
        binding.ivImg.loadUrlImage(state.thumbnail)
        binding.tvTitle.text = state.title
    }
}