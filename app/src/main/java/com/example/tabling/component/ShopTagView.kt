package com.example.tabling.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.example.tabling.R

class ShopTagView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        background = AppCompatResources.getDrawable(context, R.drawable.bg_shop_tag)
        setTextColor(ResourcesCompat.getColor(resources,R.color.blue,null))
        val horizontalPadding = resources.getDimensionPixelOffset(R.dimen.shop_tag_horizontal_padding)
        val verticalPadding = resources.getDimensionPixelOffset(R.dimen.shop_tag_vertical_padding)
        setPadding(horizontalPadding,verticalPadding,horizontalPadding,verticalPadding)
    }

}