package com.example.tabling.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabling.databinding.FragTablingBinding
import com.google.android.material.tabs.TabLayoutMediator

class TablingFragment : Fragment() {

    private var _binding: FragTablingBinding? = null

    private val binding get() = _binding!!


    private lateinit var tabAdapter: TabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragTablingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabAdapter = TabAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.tabPageContainer.offscreenPageLimit = 2
        binding.tabPageContainer.adapter = tabAdapter

        TabLayoutMediator(binding.tabLayout,  binding.tabPageContainer) { tab, position ->
            val tabType =  TabType.values()[position]
            tab.setText(tabType.titleResId)
            tab.id = tabType.tabId
            tab
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}