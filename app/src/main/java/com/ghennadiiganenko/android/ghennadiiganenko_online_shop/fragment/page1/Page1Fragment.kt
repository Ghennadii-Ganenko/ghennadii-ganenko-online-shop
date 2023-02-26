package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentPage1Binding
import kotlin.properties.Delegates

class Page1Fragment : Fragment() {
    private var binding: FragmentPage1Binding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        return binding.root
    }
}