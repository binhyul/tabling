package com.example.tabling.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tabling.R
import com.example.tabling.databinding.FragTabBinding
import com.example.tabling.ui.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabFragment : Fragment() {

    private var _binding: FragTabBinding? = null

    private val binding get() = _binding!!

    private val viewModel: TablingViewModel by viewModels({
        requireParentFragment()
    })

    private val shopItemController = object : ShopItemController {
        override fun clickShop(shopModel: ShopModel) {
            val action = TablingFragmentDirections.actionTablingFragmentToDetailFragment(shopModel)
            findNavController().navigate(action)
        }
    }

    private val shopAdapter = ShopAdapter(shopItemController)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.onLoading()
        binding.rvTabItems.adapter = shopAdapter
        binding.rvTabItems.addItemDecoration(
            ShopComponentItemDecoration(
                resources.getDimensionPixelOffset(
                    R.dimen.shop_view_offset
                )
            )
        )

        val tabType: TabType = arguments?.getParcelable(TYPE) ?: TabType.SAVE
        viewModel.tabItems(tabType).observe(viewLifecycleOwner) {
            binding.loadingView.onEnd()
            shopAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val TYPE = "type"

        @JvmStatic
        fun create(
            type: TabType,
        ): TabFragment =
            TabFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TYPE, type)
                }
            }
    }
}