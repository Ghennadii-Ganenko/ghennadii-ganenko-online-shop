package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentLoginBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.sign.SignInFragmentDirections
import kotlin.properties.Delegates

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding by Delegates.notNull()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.apply {
            btnLogin.setOnClickListener {
                actionToPage1Fragment()
            }
        }

        return binding.root
    }

    private fun actionToPage1Fragment() {
        val action = SignInFragmentDirections.actionSignInFragmentToPage1Fragment()

        findNavController().navigate(action)
    }
}