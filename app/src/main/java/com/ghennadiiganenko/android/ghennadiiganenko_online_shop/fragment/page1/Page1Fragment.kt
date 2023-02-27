package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentPage1Binding
import kotlin.properties.Delegates

class Page1Fragment : Fragment() {
    private var binding: FragmentPage1Binding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        binding.apply {
            bnvMenu.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.action_profile -> {
                        actionToProfileFragment()
                    }
                }

                return@setOnItemSelectedListener true
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.bnvMenu.selectedItemId = R.id.action_home
    }

    private fun actionToProfileFragment() {
        val action = Page1FragmentDirections.actionPage1FragmentToProfileFragment()

        findNavController().navigate(action)
    }
}