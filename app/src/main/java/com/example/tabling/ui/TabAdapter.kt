package com.example.tabling.ui

import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tabling.R
import kotlinx.parcelize.Parcelize


@Parcelize
enum class TabType (@StringRes val titleResId: Int,@IdRes val tabId: Int) : Parcelable {
    SAVE(R.string.save_tab,  R.id.save_tab),
    RECENT(R.string.recent_tab,  R.id.recent_tab),
    LIKE(R.string.like_tab,  R.id.like_tab);

    companion object {
    }
}


class TabAdapter(
    fragmentManager: FragmentManager,
    viewLifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, viewLifecycle) {

    override fun getItemCount(): Int {
        return TabType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        val type = TabType.values()[position]
        return TabFragment.create(type)
    }
}