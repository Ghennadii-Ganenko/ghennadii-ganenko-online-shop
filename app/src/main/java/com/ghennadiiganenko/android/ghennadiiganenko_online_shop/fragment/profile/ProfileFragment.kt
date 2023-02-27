package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentProfileBinding
import kotlin.properties.Delegates

class ProfileFragment : Fragment() {
    private var binding: FragmentProfileBinding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.apply {
            bnvMenu.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.action_home -> {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
                }

                return@setOnItemSelectedListener true
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.bnvMenu.selectedItemId = R.id.action_profile
    }
}