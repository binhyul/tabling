package com.example.tabling.ui

import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.tabling.R
import kotlinx.parcelize.Parcelize


@Parcelize
enum class TabType(@StringRes val titleResId: Int, @IdRes val tabId: Int) : Parcelable {
    SAVE(R.string.save_tab, R.id.save_tab),
    RECENT(R.string.recent_tab, R.id.recent_tab),
    LIKE(R.string.like_tab, R.id.like_tab);

    companion object {
    }
}