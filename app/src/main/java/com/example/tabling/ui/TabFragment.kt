package com.example.tabling.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabling.databinding.FragTabBinding

class TabFragment  : Fragment() {

    private var _binding: FragTabBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragTabBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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