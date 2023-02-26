package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentPage2Binding
import kotlin.properties.Delegates

class Page2Fragment : Fragment() {
    private var binding: FragmentPage2Binding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        return binding.root
    }
}