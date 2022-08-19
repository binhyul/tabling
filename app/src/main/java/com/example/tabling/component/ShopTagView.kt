package com.example.tabling.component

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
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

    private var stroke = false
    private var strokeWidth = 0f
    private var strokeColor: Int = 0

    init {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ShopTagView)
        stroke = a.getBoolean(R.styleable.ShopTagView_textStroke, false)
        strokeWidth = a.getFloat(R.styleable.ShopTagView_textStrokeWidth, 0.0f)
        strokeColor = a.getColor(R.styleable.ShopTagView_textStrokeColor, 0xffffff)
        a.recycle()

        background = AppCompatResources.getDrawable(context, R.drawable.bg_shop_tag)
        val horizontalPadding = resources.getDimensionPixelOffset(R.dimen.shop_tag_horizontal_padding)
        val verticalPadding = resources.getDimensionPixelOffset(R.dimen.shop_tag_vertical_padding)
        setPadding(horizontalPadding,verticalPadding,horizontalPadding,verticalPadding)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (stroke) {
            val states : ColorStateList = textColors
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = strokeWidth
            setTextColor(strokeColor)
            super.onDraw(canvas)

            paint.style = Paint.Style.FILL
            setTextColor(states)
        }

        super.onDraw(canvas)
    }


}