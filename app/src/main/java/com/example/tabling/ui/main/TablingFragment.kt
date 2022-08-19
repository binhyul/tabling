package com.example.tabling.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.tabling.databinding.FragTablingBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TablingFragment : Fragment() {

    private var _binding: FragTablingBinding? = null

    private val binding get() = _binding!!

    private val viewModel: TablingViewModel by viewModels()

    private val tabTypes = TabType.values()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragTablingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedTab.observe(viewLifecycleOwner) {
            if (binding.tabPageContainer.adapter == null) {
                val tabAdapter = TabAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
                binding.tabPageContainer.offscreenPageLimit = 2
                binding.tabPageContainer.adapter = tabAdapter

                TabLayoutMediator(binding.tabLayout, binding.tabPageContainer) { tab, position ->
                    val tabType = TabType.values()[position]
                    tab.setText(tabType.titleResId)
                    tab.id = tabType.tabId
                    tab
                }.attach()

            } else {
                binding.tabPageContainer.currentItem =
                    tabTypes.indexOf(it)
            }
        }

        binding.tabPageContainer.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.onSelectTab(tabTypes[position])
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}