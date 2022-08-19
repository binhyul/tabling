package com.example.tabling.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


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