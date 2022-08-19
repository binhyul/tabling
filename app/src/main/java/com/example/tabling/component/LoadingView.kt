package com.example.tabling.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.tabling.databinding.ViewLoadingBinding

class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    def: Int = 0
) : FrameLayout(
    context, attrs, def
) {
    private val binding: ViewLoadingBinding =
        ViewLoadingBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        onEnd()
    }

    fun onLoading() {
        binding.progressLoading.visibility = VISIBLE
    }

    fun onEnd() {
        binding.progressLoading.visibility = GONE
    }

}