package com.example.tabling.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tabling.R
import com.example.tabling.databinding.FragDetailBinding
import com.example.tabling.loadUrlImage
import com.example.tabling.onThrottleClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragDetailBinding? = null

    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.shopModel.observe(viewLifecycleOwner) {
            binding.tvCategory.text = it.category
            binding.ivImg.loadUrlImage(it.thumbnail)
            binding.tvTitle.text = it.title
            binding.tvPlace.text = it.place

            val reviewCountText = if (it.reviewCount > 300) {
                resources.getString(R.string.shop_review_count_over)
            } else {
                it.reviewCount.toString()
            }
            binding.tvRating.text =
                resources.getString(R.string.shop_rating, it.rating.toString(), reviewCountText)

            binding.ivLike.setImageResource(
                if (it.like) {
                    R.drawable.ic_heart_filled_24
                } else {
                    R.drawable.ic_heart_empty_24
                }
            )
        }

        binding.ivLike.onThrottleClick {
            viewModel.onClickLike()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}